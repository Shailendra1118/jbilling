package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.Product;
import com.prizy.entities.repo.intf.IProductRepository;
import com.prizy.services.intf.IProductService;

/**
 * @author Shailendra
 *
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public void create(Product product) {
		repo.save(product);
	}

	@Override
	public List<Long> getAllProductIds() {
		return repo.findAllProductIds();
	}

	@Override
	public boolean isExists(String name) {
		if (repo.findByName(name) == null)
			return false;
		else
			return true;
	}

}
