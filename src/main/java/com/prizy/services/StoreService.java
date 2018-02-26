package com.prizy.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.Store;
import com.prizy.entities.repo.intf.IStoreRepository;
import com.prizy.services.intf.IStoreService;

/**
 * @author Shailendra
 *
 */
@Service
public class StoreService implements IStoreService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStoreRepository repo;

	@Override
	public List<Store> getAllStores() {
		logger.info("Store serices..");
		return repo.findAll();
	}

	@Override
	public void create(Store store) {
		logger.info("Store creating..");
		repo.save(store);
	}

	@Override
	public Store getStore(long id) {
		logger.info("Get single store..");
		return repo.findOne(id);
	}

}
