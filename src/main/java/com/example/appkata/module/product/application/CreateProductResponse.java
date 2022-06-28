package com.example.appkata.module.product.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class CreateProductResponse {
	private long id;
	private String productName;
	private int price;

	public CreateProductResponse(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}
}
