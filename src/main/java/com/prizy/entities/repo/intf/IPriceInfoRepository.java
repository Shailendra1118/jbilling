package com.prizy.entities.repo.intf;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.prizy.entities.PriceInfo;

public interface IPriceInfoRepository extends JpaRepository<PriceInfo, Long> {

	public List<PriceInfo> findByProductId(Long productId);

	@Transactional
	@Modifying
	@Query("update PriceInfo p set p.idealPrice = ?1, p.updatedAt = ?2 where p.productId = ?3")
	public void updateIdealPrice(Long idealPrice, Date updatedDate,
			Long productId);
}
