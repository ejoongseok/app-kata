package com.example.appkata.module.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.CreateProductResponse;
import com.example.appkata.module.product.application.ProductService;
import com.example.appkata.module.product.application.UpdateProductRequest;
import com.example.appkata.module.product.application.UpdateProductResponse;
import com.example.appkata.module.product.domain.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateProductResponse create(@RequestBody CreateProductRequest request) {
		Product product = productService.createProduct(request);
		return new CreateProductResponse(product);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest request) {
		return null;
	}
}
