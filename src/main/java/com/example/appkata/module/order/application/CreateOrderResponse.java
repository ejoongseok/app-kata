package com.example.appkata.module.order.application;

public class CreateOrderResponse {
	private long orderId;
	private long productId;
	private int quantity;
	private int totalPrice;
	private String productName;

	public long getOrderId() {
		return orderId;
	}

	public long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public String getProductName() {
		return productName;
	}
}
