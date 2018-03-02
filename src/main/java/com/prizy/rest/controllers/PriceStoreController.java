package com.prizy.rest.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.StorePrice;
import com.prizy.services.intf.IPriceStoreService;

/**
 * @author Shailendra
 *
 */
@RestController
public class PriceStoreController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPriceStoreService service;

	@RequestMapping(value = "/storeprice/{id}", method = RequestMethod.GET)
	public ResponseEntity<StorePrice> getStorePrice(@PathVariable("id") long id) {
		logger.info("getStorePrice called...");
		StorePrice priceStore = service.getPriceStore(id);
		if (Objects.isNull(priceStore)) {
			return new ResponseEntity<StorePrice>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StorePrice>(priceStore, HttpStatus.OK);
	}

	@RequestMapping(value = "/store/product", method = RequestMethod.POST)
	public ResponseEntity<StorePrice> createStorePrice(
			@RequestBody StorePrice storePrice) {
		logger.info("createStorePrice : {}", storePrice);
		List<StorePrice> existing = service.getProductPrice(
				storePrice.getProductId(), storePrice.getStoreId());
		if (!existing.isEmpty()) {
			StorePrice price = existing.iterator().next();
			logger.error(
					"Unable to create. A StorePrice of this product {} in store {} already exist",
					price.getProductId(), price.getStoreId());
			return new ResponseEntity<StorePrice>(HttpStatus.CONFLICT);
		}

		service.create(storePrice);
		return new ResponseEntity<StorePrice>(storePrice, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/storeprice", method = RequestMethod.GET)
	public ResponseEntity<List<StorePrice>> getStorePriceWithCriteria(
			@RequestParam(value = "storeid") Long sid,
			@RequestParam(value = "productid") Long pid) {
		logger.info("getStorePriceWithCriteria called...");
		List<StorePrice> priceStore = service.getProductPrice(pid, sid);
		if (Objects.isNull(priceStore) || priceStore.isEmpty()) {
			return new ResponseEntity<List<StorePrice>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StorePrice>>(priceStore, HttpStatus.OK);
	}

}
