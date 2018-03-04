/**
 * 
 */
package com.prizy.entities.builders;

import java.util.function.Consumer;

import com.prizy.entities.PriceInfo;

/**
 * @author Shailendra
 *
 */
public class PriceInfoBuilder {

	private Long id;
	private Long productId;
	private Long idealPrice;

	public PriceInfoBuilder with(Consumer<PriceInfoBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public PriceInfo createPriceInfo() {
		return new PriceInfo(id, productId, idealPrice);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @param idealPrice
	 *            the idealPrice to set
	 */
	public void setIdealPrice(Long idealPrice) {
		this.idealPrice = idealPrice;
	}
}
