package com.example.appkata.module.order.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.module.order.application.CreateOrderRequest;
import com.example.appkata.module.order.application.CreateOrderResponse;

@RestController
@RequestMapping("/orders")
public class OrderApi {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateOrderResponse order(@RequestBody CreateOrderRequest request) {
		return null;
	}
}
