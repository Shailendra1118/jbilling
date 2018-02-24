package com.prizy.entities.repo.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizy.entities.PriceInfo;

public interface IPriceInfoRepository extends JpaRepository<PriceInfo, Long> {

	public List<PriceInfo> findByProductId(Long productId);
}
