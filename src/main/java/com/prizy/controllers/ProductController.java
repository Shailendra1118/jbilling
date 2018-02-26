package com.prizy.controllers;

/**
 * @author Shailendra
 *
 */
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

import com.prizy.entities.Product;
import com.prizy.services.intf.IProductService;

@RestController
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		logger.info("getAllProducts  called...");
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
		logger.info("getProduct called...");
		Product product = productService.getProductById(id);
		if (Objects.isNull(product)) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		logger.info("createProduct : {}", product);
		productService.create(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
}