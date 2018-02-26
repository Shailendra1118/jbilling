package com.prizy.price.strategies;

import java.util.List;

import com.prizy.entities.StorePrice;

public interface IIdealPriceStrategy {

	public Long calculate(List<StorePrice> prices);
}
