package com.prizy.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prizy.entities.PriceInfo;
import com.prizy.entities.repo.intf.IPriceInfoRepository;
import com.prizy.services.intf.IPriceInfoService;

/**
 * @author Shailendra
 *
 */
@Service
public class PriceInfoService implements IPriceInfoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPriceInfoRepository repo;

	@Override
	@Cacheable("priceinfos")
	public List<PriceInfo> getPriceInfo(Long productId) {
		logger.info("getPriceInfo called...");
		return repo.findByProductId(productId);
	}

	@Override
	@CachePut(value = "priceinfos", key = "#productId", unless = "#result==null")
	public void updateIdeaPrice(Long productId, Date updatedAt, Long idealPrice) {
		logger.info("updateIdeaPrice called...");
		repo.updateIdealPrice(idealPrice, updatedAt, productId);
	}

}
