package com.prizy.entities.vo;

/**
 * 
 * @author Shailendra
 *
 */
public class PriceDetails {

	private Long productId;
	private String productName;
	private String desc;
	private Long basePrice;
	private Long averagePrice;
	private Long lowestPrice;
	private Long highestPrice;
	private Long idealPrice;
	private Long countOfDiffPrices;

	/**
	 * @param productId2
	 * @param productName2
	 * @param desc2
	 * @param basePrice2
	 * @param averagePrice2
	 * @param lowestPrice2
	 * @param highestPrice2
	 * @param idealPrice2
	 * @param countOfDiffPrices2
	 */
	public PriceDetails(Long productId2, String productName2, String desc2,
			Long basePrice2, Long averagePrice2, Long lowestPrice2,
			Long highestPrice2, Long idealPrice2, Long countOfDiffPrices2) {
		this.productId = productId2;
		this.productName = productName2;
		this.desc = desc2;
		this.basePrice = basePrice2;
		this.averagePrice = averagePrice2;
		this.lowestPrice = lowestPrice2;
		this.highestPrice = highestPrice2;
		this.idealPrice = idealPrice2;
		this.idealPrice = idealPrice2;
		this.countOfDiffPrices = countOfDiffPrices2;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the basePrice
	 */
	public Long getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice
	 *            the basePrice to set
	 */
	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return the averagePrice
	 */
	public Long getAveragePrice() {
		return averagePrice;
	}

	/**
	 * @param averagePrice
	 *            the averagePrice to set
	 */
	public void setAveragePrice(Long averagePrice) {
		this.averagePrice = averagePrice;
	}

	/**
	 * @return the lowestPrice
	 */
	public Long getLowestPrice() {
		return lowestPrice;
	}

	/**
	 * @param lowestPrice
	 *            the lowestPrice to set
	 */
	public void setLowestPrice(Long lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	/**
	 * @return the highestPrice
	 */
	public Long getHighestPrice() {
		return highestPrice;
	}

	/**
	 * @param highestPrice
	 *            the highestPrice to set
	 */
	public void setHighestPrice(Long highestPrice) {
		this.highestPrice = highestPrice;
	}

	/**
	 * @return the idealPrice
	 */
	public Long getIdealPrice() {
		return idealPrice;
	}

	/**
	 * @param idealPrice
	 *            the idealPrice to set
	 */
	public void setIdealPrice(Long idealPrice) {
		this.idealPrice = idealPrice;
	}

	/**
	 * @return the countOfDiffPrices
	 */
	public Long getCountOfDiffPrices() {
		return countOfDiffPrices;
	}

	/**
	 * @param countOfDiffPrices
	 *            the countOfDiffPrices to set
	 */
	public void setCountOfDiffPrices(Long countOfDiffPrices) {
		this.countOfDiffPrices = countOfDiffPrices;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + this.productId.hashCode();
		result = result * prime + this.productName.hashCode();
		result = result * prime + this.basePrice.hashCode();
		return 0;

	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof PriceDetails)) {
			return false;
		}

		PriceDetails other = (PriceDetails) o;
		return other.productId.equals(this.productId)
				&& other.productName.equals(this.productName)
				&& other.basePrice.equals(this.basePrice);
	}
}
