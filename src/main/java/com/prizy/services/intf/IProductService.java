package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.Product;

/**
 * @author Shailendra
 *
 */
public interface IProductService {

	List<Product> getAllProducts();

	List<Long> getAllProductIds();

	Product getProductById(Long id);

	void create(Product product);

}
