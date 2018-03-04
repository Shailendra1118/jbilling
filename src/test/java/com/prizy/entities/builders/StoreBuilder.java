/**
 * 
 */
package com.prizy.entities.builders;

import java.util.function.Consumer;

import com.prizy.entities.Store;

/**
 * @author Shailendra
 *
 */
public class StoreBuilder {
	private Long id;
	private String name;
	private String desc;
	private String location;

	public StoreBuilder with(Consumer<StoreBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public Store createStore() {
		return new Store(id, name, desc, location);
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
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
