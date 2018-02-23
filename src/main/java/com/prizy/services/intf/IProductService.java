package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.Product;

public interface IProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public void create(Product product);

}
