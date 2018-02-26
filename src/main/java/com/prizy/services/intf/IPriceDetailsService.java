package com.prizy.services.intf;

import com.prizy.entities.vo.PriceDetails;

/**
 * @author Shailendra
 *
 */
public interface IPriceDetailsService {

	PriceDetails getPriceDetails(Long pid);
}
