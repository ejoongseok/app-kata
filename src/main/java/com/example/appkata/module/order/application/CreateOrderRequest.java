package com.example.appkata.module.order.application;

public class CreateOrderRequest {
	private long productId;
	private int quantity;

	public CreateOrderRequest(Long productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public static CreateOrderRequest of(Long productId, int quantity) {
		return new CreateOrderRequest(productId, quantity);
	}
}
