package com.prizy.entities.repo.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prizy.entities.Product;

/**
 * @author Shailendra
 *
 */
public interface IProductRepository extends JpaRepository<Product, Long> {

	@Query("select distinct(p.id) from Product p")
	List<Long> findAllProductIds();

}
