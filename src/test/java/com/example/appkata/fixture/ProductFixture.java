package com.example.appkata.fixture;

import org.springframework.stereotype.Component;

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.ProductService;

@Component
public class ProductFixture {

	private final ProductService productService;

	public ProductFixture(ProductService productService) {
		this.productService = productService;
	}

	public void createProduct(String oldProductName, int oldPrice) {
		CreateProductRequest request = new CreateProductRequest(oldProductName, oldPrice);
		productService.createProduct(request);
	}
}
