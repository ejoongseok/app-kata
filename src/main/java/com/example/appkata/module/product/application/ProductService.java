package com.example.appkata.module.product.application;

import com.example.appkata.module.product.domain.Product;

public class ProductService {
	private ProductRepository productRepository;

	public Product createProduct(CreateProductRequest request) {
		Product product = new Product(request.getProductName(), request.getPrice());
		productRepository.save(product);
		return product;
	}
}
