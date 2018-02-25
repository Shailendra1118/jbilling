package com.prizy.price.strategies;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.StorePrice;
import com.prizy.services.intf.IPriceInfoService;
import com.prizy.services.intf.IPriceStoreService;

@Service
public abstract class IdealPriceStrategy implements IIdealPriceStrategy {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IPriceStoreService priceStoreService;

	@Autowired
	IPriceInfoService priceInfoService;

	public Long productId;
	protected Long idealPrice;
	protected List<StorePrice> prices;

	// template Method
	public void execute() {
		logger.info("IdealPriceStrategy execute...");
		fetchAllPrices();
		calculate(prices);
		updateIdeal();
	}

	abstract void calculate(List<StorePrice> prices);

	protected void fetchAllPrices() {
		logger.info("fetchAllPrices...");
		prices = priceStoreService.getProductPrices(productId);
	}

	protected void updateIdeal() {
		logger.info("updateIdeal...");
		priceInfoService.updateIdeaPrice(idealPrice, productId);
	}

	public void setProductId(Long pid) {
		this.productId = pid;
	}

}
