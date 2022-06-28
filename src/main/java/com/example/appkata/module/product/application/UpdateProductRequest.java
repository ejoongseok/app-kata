package com.example.appkata.module.product.application;

public class UpdateProductRequest {
	private final String productName;
	private final int price;

	public UpdateProductRequest(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public static UpdateProductRequest of(String newProductName, int newPrice) {
		return new UpdateProductRequest(newProductName, newPrice);
	}
}
