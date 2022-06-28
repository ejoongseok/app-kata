package com.example.appkata.module.order.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.module.order.application.CreateOrderRequest;
import com.example.appkata.module.order.application.CreateOrderResponse;
import com.example.appkata.module.order.application.OrderService;
import com.example.appkata.module.order.domain.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderApi {

	private final OrderService orderService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateOrderResponse order(@RequestBody CreateOrderRequest request) {
		Order order = orderService.order(request);
		return new CreateOrderResponse(order);
	}
}
