package com.prizy.entities.repo.intf;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizy.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
