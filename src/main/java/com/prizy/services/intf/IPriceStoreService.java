package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.StorePrice;

public interface IPriceStoreService {

	List<StorePrice> getAllPriceStore();

	StorePrice getPriceStore(Long id);

	List<StorePrice> getProductPrice(Long productId, Long storeId);

	Long getLowestPrice(Long productId);

	Long getHighestPrice(Long productId);

	Long getAveragePrice(Long productId);

	void create(StorePrice priceStore);
}
