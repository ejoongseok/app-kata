package com.example.appkata.module.product.application;

import lombok.Getter;

@Getter
public class CreateProductRequest {
	private String productName;
	private int price;

	public CreateProductRequest(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public static CreateProductRequest of(String productName, int price) {
		return new CreateProductRequest(productName, price);
	}
}
