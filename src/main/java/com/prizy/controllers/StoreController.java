package com.prizy.controllers;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.Store;
import com.prizy.services.intf.IStoreService;

@RestController
public class StoreController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStoreService storeService;

	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public ResponseEntity<List<Store>> getAllStores() {
		logger.info("getAllStores  called...");
		List<Store> stores = storeService.getAllStores();
		if (stores.isEmpty()) {
			return new ResponseEntity<List<Store>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}

	@RequestMapping(value = "/store/{id}", method = RequestMethod.GET)
	public ResponseEntity<Store> getStore(@PathVariable("id") long id) {
		logger.info("getStore called...");
		Store store = storeService.getStore(id);
		if (Objects.isNull(store)) {
			return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ResponseEntity<Store> createStore(@RequestBody Store store) {
		logger.info("Creating Store : {}", store);
		storeService.create(store);
		return new ResponseEntity<Store>(store, HttpStatus.CREATED);
	}

}
