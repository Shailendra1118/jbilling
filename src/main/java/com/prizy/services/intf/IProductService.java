package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.Product;

/**
 * @author Shailendra
 *
 */
public interface IProductService {

	/**
	 * Returns all products
	 * 
	 * @return
	 */
	List<Product> getAllProducts();

	/**
	 * Returns all product ids
	 * 
	 * @return
	 */
	List<Long> getAllProductIds();

	/**
	 * Return Product with given Id
	 * 
	 * @param id
	 * @return
	 */
	Product getProductById(Long id);

	/**
	 * Create new product
	 * 
	 * @param product
	 */
	void create(Product product);

	/**
	 * Checks if product with given name exists already
	 * 
	 * @param name
	 * @return
	 */
	boolean isExists(String name);

}
