package com.example.appkata.module.order.application;

import lombok.Getter;

@Getter
public class FindOrderResponse {
	private Long id;
	private Long productId;
	private String productName;
	private int totalPrice;
	private int quantity;

}
