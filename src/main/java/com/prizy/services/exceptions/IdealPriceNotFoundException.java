package com.prizy.services.exceptions;

public class IdealPriceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdealPriceNotFoundException(String message) {
		super(message);
	}
}
