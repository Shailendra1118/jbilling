package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.PriceInfo;
import com.prizy.entities.Product;
import com.prizy.entities.vo.PriceDetails;
import com.prizy.services.exceptions.IdealPriceNotFoundException;
import com.prizy.services.intf.IPriceDetailsService;
import com.prizy.services.intf.IPriceInfoService;
import com.prizy.services.intf.IPriceStoreService;
import com.prizy.services.intf.IProductService;

/**
 * @author Shailendra
 *
 */
@Service
public class PriceDetailsService implements IPriceDetailsService {

	@Autowired
	private IPriceInfoService priceInfoService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IPriceStoreService priceStoreService;

	@Override
	public PriceDetails getPriceDetails(Long pid) {
		List<PriceInfo> idealPrice = priceInfoService.getPriceInfo(pid);
		if (idealPrice.isEmpty()) {
			throw new IdealPriceNotFoundException("product: " + pid);
		}
		PriceDetails details = new PriceDetails();
		details.setProductId(pid);
		Product prod = productService.getProductById(pid);
		details.setProductName(prod.getName());
		details.setDesc(prod.getLongDescription());
		details.setBasePrice(prod.getBasePrice());
		details.setLowestPrice(priceStoreService.getLowestPrice(pid));
		details.setHighestPrice(priceStoreService.getHighestPrice(pid));
		details.setAveragePrice(priceStoreService.getAveragePrice(pid));
		details.setCountOfDiffPrices(priceStoreService
				.getTotalPriceEntries(pid));
		details.setIdealPrice(idealPrice.iterator().next().getIdealPrice());

		return details;
	}
}
