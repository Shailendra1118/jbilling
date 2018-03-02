/**
 * 
 */
package com.prizy.entities.builders;

import java.util.function.Consumer;

import com.prizy.entities.vo.PriceDetails;

/**
 * @author Shailendra
 *
 */
public class PriceDetailsBuilder {

	private Long productId;
	private String productName;
	private String desc;
	private Long basePrice;
	private Long averagePrice;
	private Long lowestPrice;
	private Long highestPrice;
	private Long idealPrice;
	private Long countOfDiffPrices;

	public PriceDetailsBuilder with(
			Consumer<PriceDetailsBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public PriceDetails createProduct() {
		return new PriceDetails(productId, productName, desc, basePrice,
				averagePrice, lowestPrice, highestPrice, idealPrice,
				countOfDiffPrices);
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param basePrice
	 *            the basePrice to set
	 */
	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @param averagePrice
	 *            the averagePrice to set
	 */
	public void setAveragePrice(Long averagePrice) {
		this.averagePrice = averagePrice;
	}

	/**
	 * @param lowestPrice
	 *            the lowestPrice to set
	 */
	public void setLowestPrice(Long lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	/**
	 * @param highestPrice
	 *            the highestPrice to set
	 */
	public void setHighestPrice(Long highestPrice) {
		this.highestPrice = highestPrice;
	}

	/**
	 * @param idealPrice
	 *            the idealPrice to set
	 */
	public void setIdealPrice(Long idealPrice) {
		this.idealPrice = idealPrice;
	}

	/**
	 * @param countOfDiffPrices
	 *            the countOfDiffPrices to set
	 */
	public void setCountOfDiffPrices(Long countOfDiffPrices) {
		this.countOfDiffPrices = countOfDiffPrices;
	}

}
