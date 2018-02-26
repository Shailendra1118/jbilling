package com.prizy.services.intf;

import java.util.Date;
import java.util.List;

import com.prizy.entities.PriceInfo;

/**
 * @author Shailendra
 *
 */
public interface IPriceInfoService {

	List<PriceInfo> getPriceInfo(Long productId);

	void updateIdeaPrice(Long productId, Date updatedAt, Long idealPrice);

}
