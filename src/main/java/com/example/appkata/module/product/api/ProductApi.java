package com.example.appkata.module.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.CreateProductResponse;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateProductResponse create(@RequestBody CreateProductRequest request) {
		return new CreateProductResponse("productName", 100);
	}
}
