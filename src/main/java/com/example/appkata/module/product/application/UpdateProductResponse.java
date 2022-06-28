package com.example.appkata.module.product.application;

import com.example.appkata.module.product.domain.Product;

import lombok.Getter;

@Getter
public class UpdateProductResponse {
	private Long id;
	private String productName;
	private int price;

	public UpdateProductResponse(Product updateProduct) {
		this.id = updateProduct.getId();
		this.productName = updateProduct.getName();
		this.price = updateProduct.getPrice();
	}
}
