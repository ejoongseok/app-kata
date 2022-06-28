package com.example.appkata.module.order.application;

public class FindOrderResponse {
	private Long id;
	private Long productId;
	private String productName;
	private int totalPrice;
	private int quantity;

	public Long getId() {
		return id;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}
}
