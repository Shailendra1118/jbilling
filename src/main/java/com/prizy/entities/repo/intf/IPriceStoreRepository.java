package com.prizy.entities.repo.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizy.entities.StorePrice;

public interface IPriceStoreRepository extends JpaRepository<StorePrice, Long> {

	public List<StorePrice> findByProductIdAndStoreId(Long pId, Long sId);

}
