package com.prizy.services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.prizy.entities.StorePrice;
import com.prizy.job.config.AsyncExecutor;
import com.prizy.price.strategies.IIdealPriceStrategy;
import com.prizy.services.intf.IPriceInfoService;
import com.prizy.services.intf.IPriceStoreService;
import com.prizy.services.intf.IProductService;

/**
 * @author Shailendra
 *
 */
@Component
public class PriceCalJobService {

	@Autowired
	private IIdealPriceStrategy strategy;

	@Autowired
	private IPriceStoreService priceStoreService;

	@Autowired
	IProductService productService;

	@Autowired
	IPriceInfoService priceInfoService;

	@Autowired
	private AsyncExecutor asyncExecutor;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String jobName = "IdealPriceCalculator";
	private Date startedAt = null;
	private final int chunkSize = 1;

	@Async
	public void execute() {
		Executor executor = asyncExecutor.getAsyncExecutor();

		// fetch all distinct products from product table
		List<Long> pIds = productService.getAllProductIds();
		logger.info("Total products: " + pIds.size());
		List<List<Long>> listOfListOfPids = ListUtils
				.partition(pIds, chunkSize);
		for (List<Long> list : listOfListOfPids) {
			executor.execute(new CalculationWorker(strategy, priceStoreService,
					list));
		}
	}

	class CalculationWorker implements Runnable {

		private IIdealPriceStrategy strategy;
		private IPriceStoreService priceStoreService;
		private List<Long> prodIds;

		public CalculationWorker(IIdealPriceStrategy strategy,
				IPriceStoreService priceStoreService, List<Long> prodIds) {
			this.strategy = strategy;
			this.prodIds = prodIds;
			this.priceStoreService = priceStoreService;
		}

		@Override
		public void run() {
			logger.info("IdealPriceCalculator started running with "
					+ Thread.currentThread().getName());
			startedAt = new Date();
			// 1. fetch StorePrices for assigned products and calculate ideal
			// price
			for (Long pId : prodIds) {
				List<StorePrice> prices = priceStoreService
						.getProductPrices(pId);

				Long idealPrice = strategy.calculate(prices);
				// 2. update ideal price
				priceInfoService.updateIdeaPrice(pId, new Date(), idealPrice);
			}

		}
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @return the startedAt
	 */
	public Date getStartedAt() {
		return startedAt;
	}
}
