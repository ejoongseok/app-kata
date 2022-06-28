package com.example.appkata.module.product.application;

import lombok.Getter;

@Getter
public class CreateProductResponse {
	private long id;
	private String productName;
	private int price;

	public long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}
}
