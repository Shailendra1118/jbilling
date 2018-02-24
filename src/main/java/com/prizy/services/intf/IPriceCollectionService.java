package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.StorePrice;

public interface IPriceCollectionService {

	public List<StorePrice> getAllPriceStore();

	public StorePrice getPriceStore(Long id);

	public List<StorePrice> getProductPrice(Long productId, Long storeId);

	public void create(StorePrice priceStore);
}
