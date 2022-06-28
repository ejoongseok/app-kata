package com.example.appkata.fixture;

import org.springframework.stereotype.Component;

import com.example.appkata.module.order.application.CreateOrderRequest;
import com.example.appkata.module.order.application.OrderService;
import com.example.appkata.module.order.domain.Order;
import com.example.appkata.module.product.domain.Product;

@Component
public class OrderFixture {
	private final OrderService orderService;

	public OrderFixture(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order createOrder(Product product, int quantity) {
		CreateOrderRequest request = CreateOrderRequest.of(product.getId(), quantity);
		Order order = orderService.order(request);
		return order;
	}
}
