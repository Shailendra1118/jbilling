package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.PriceInfo;
import com.prizy.entities.Product;
import com.prizy.entities.builders.PriceDetailsBuilder;
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

		PriceDetails details = new PriceDetailsBuilder().with(
				builder -> {
					builder.setProductId(pid);
					Product prod = productService.getProductById(pid);
					builder.setDesc(prod.getLongDescription());
					builder.setProductName(prod.getName());
					builder.setBasePrice(prod.getBasePrice());
					builder.setAveragePrice(priceStoreService
							.getAveragePrice(pid));
					builder.setLowestPrice(priceStoreService
							.getLowestPrice(pid));
					builder.setHighestPrice(priceStoreService
							.getHighestPrice(pid));
					builder.setIdealPrice(idealPrice.iterator().next()
							.getIdealPrice());
					builder.setCountOfDiffPrices(priceStoreService
							.getTotalPriceEntries(pid));

				}).createProduct();

		return details;
	}
}
