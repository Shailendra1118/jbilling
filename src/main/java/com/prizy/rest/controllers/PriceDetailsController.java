package com.prizy.rest.controllers;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.entities.vo.PriceDetails;
import com.prizy.services.intf.IPriceDetailsService;

/**
 * 
 * @author Shailendra
 *
 */
@RestController
public class PriceDetailsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPriceDetailsService service;

	@RequestMapping(value = "/product/{productId}/prices", method = RequestMethod.GET)
	public ResponseEntity<PriceDetails> getPriceDetails(
			@PathVariable("productId") long id) {
		logger.info("getPriceDetails called...");
		PriceDetails details = service.getPriceDetails(id);
		if (Objects.isNull(details)) {
			return new ResponseEntity<PriceDetails>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PriceDetails>(details, HttpStatus.OK);
	}

}
