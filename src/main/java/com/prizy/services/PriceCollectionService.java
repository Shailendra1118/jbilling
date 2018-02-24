package com.prizy.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.StorePrice;
import com.prizy.entities.repo.intf.IPriceStoreRepository;
import com.prizy.services.intf.IPriceCollectionService;

@Service
public class PriceCollectionService implements IPriceCollectionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPriceStoreRepository repo;

	@Override
	public List<StorePrice> getAllPriceStore() {
		logger.info("getAllPriceStore..");
		return repo.findAll();
	}

	@Override
	public List<StorePrice> getProductPrice(Long productId, Long storeId) {
		logger.info("getProductPrice..");
		return repo.findByProductIdAndStoreId(productId, storeId);
	}

	@Override
	public void create(StorePrice priceStore) {
		repo.save(priceStore);
	}

	@Override
	public StorePrice getPriceStore(Long id) {
		return repo.findOne(id);
	}

}
