package com.example.appkata.module.order.application;

import lombok.Getter;

@Getter
public class CreateOrderResponse {
	private long orderId;
	private long productId;
	private int quantity;
	private int totalPrice;
	private String productName;

}
