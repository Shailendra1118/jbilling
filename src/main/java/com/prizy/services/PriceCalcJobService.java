package com.prizy.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.prizy.entities.StorePrice;
import com.prizy.job.config.AsyncExecutor;
import com.prizy.price.strategies.IIdealPriceStrategy;
import com.prizy.services.intf.IPriceCalcJobService;
import com.prizy.services.intf.IPriceInfoService;
import com.prizy.services.intf.IPriceStoreService;
import com.prizy.services.intf.IProductService;

/**
 * @author Shailendra
 *
 */
@Component
public class PriceCalcJobService implements IPriceCalcJobService {

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
	private final int chunkSize = 1;
	private ThreadPoolTaskExecutor executor;

	// private volatile boolean running;
	private AtomicBoolean status = new AtomicBoolean(false); // means not
																// running

	@Async
	public void calculate() {
		executor = asyncExecutor.getAsyncExecutor();
		List<Future<?>> flist = new ArrayList<>();
		List<Long> pIds = productService.getAllProductIds();
		logger.info("Total products: " + pIds.size());
		List<List<Long>> listOfListOfPids = ListUtils
				.partition(pIds, chunkSize);
		for (List<Long> list : listOfListOfPids) {
			Future<?> f = executor.submit(new CalculationWorker(strategy,
					priceStoreService, list));
			flist.add(f);

		}
		logger.info("All calculations task are submitted");

		for (Future<?> f : flist) {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		logger.info("All calculations are completed.");
		status.set(false);

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
			// TODO simulate heavy processing
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
	 * @return the status
	 */
	public AtomicBoolean getStatus() {
		return status;
	}

}
