package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.PriceInfo;
import com.prizy.entities.repo.intf.IPriceInfoRepository;
import com.prizy.services.intf.IPriceInfoService;

@Service
public class PriceInfoService implements IPriceInfoService {

	@Autowired
	private IPriceInfoRepository repo;

	@Override
	public List<PriceInfo> getPriceInfo(Long productId) {
		return repo.findByProductId(productId);
	}

}
