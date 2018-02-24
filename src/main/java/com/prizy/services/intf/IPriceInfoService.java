package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.PriceInfo;

public interface IPriceInfoService {

	List<PriceInfo> getPriceInfo(Long productId);
}
