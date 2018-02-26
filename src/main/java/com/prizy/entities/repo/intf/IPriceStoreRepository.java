package com.prizy.entities.repo.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prizy.entities.StorePrice;

/**
 * @author Shailendra
 *
 */
public interface IPriceStoreRepository extends JpaRepository<StorePrice, Long> {

	public List<StorePrice> findByProductIdAndStoreId(Long pId, Long sId);

	@Query("select min(p.storePrice) from StorePrice p where p.productId = ?1")
	public Long findLowestPrice(Long productId);

	@Query("select max(p.storePrice) from StorePrice p where p.productId = ?1")
	public Long findHighestPrice(Long productId);

	@Query("select avg(p.storePrice) from StorePrice p where p.productId = ?1")
	public Long findAveragePrice(Long productId);

	@Query("select count(p.storePrice) from StorePrice p where p.productId = ?1")
	public Long findTotalPriceEntries(Long productId);

	public List<StorePrice> findByProductId(Long productId);

}
