/**
 * 
 */
package com.prizy.entities.builders;

import java.util.function.Consumer;

import com.prizy.entities.Product;

/**
 * @author Shailendra
 *
 */
public class ProductBuilder {

	private Long id;
	private String name;
	private String longDescription;
	private Long basePrice;
	private String type;
	private Float rating;
	private String imgUrl;

	public ProductBuilder with(Consumer<ProductBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public Product createProduct() {
		return new Product(id, name, longDescription, basePrice, type, rating,
				imgUrl);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param longDescription
	 *            the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	/**
	 * @param basePrice
	 *            the basePrice to set
	 */
	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}

	/**
	 * @param imgUrl
	 *            the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
