package com.prizy.price.strategies;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prizy.entities.StorePrice;

@Service
public class IdeaPriceBy20Percent extends IdealPriceStrategy {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/***
	 * This price is calculated by taking all the prices of this product,
	 * removing the 2 highest and 2 lowest, then doing an average with the rest
	 * and adding 20% to it.
	 */
	public void calculate(List<StorePrice> prices) {

		// 1. remove 2 highest and lowest prices
		List<Long> ideals = prices.stream().map(StorePrice::getStorePrice)
				.collect(Collectors.toList());
		logger.info("Before removing max and min: " + ideals.size());
		ideals = ideals.stream().sorted((s2, s1) -> {
			if (s1 < s2)
				return -1;
			else if (s1 > s2)
				return 1;
			else
				return 0;
		}).skip(2).sorted((s1, s2) -> {
			if (s1 < s2)
				return -1;
			else if (s1 > s2)
				return 1;
			else
				return 0;
		}).skip(2).collect(Collectors.toList());
		// prices.removeIf(x-> x == max);
		logger.info("After removing max and min: " + ideals.size());

		// 2.calculate average
		Double avg = ideals.stream().mapToLong(x -> x).average().getAsDouble();

		// 3.calculate 20% and add
		Double twentyPer = 20 * avg / 100;
		final Double ideal = avg + twentyPer;
		idealPrice = ideal.longValue();
		logger.info("Ideal price is :" + ideal);
	}

}
