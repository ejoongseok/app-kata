package com.example.appkata.module.product.application;

import com.example.appkata.module.product.domain.Product;
import com.example.appkata.module.product.domain.ProductRepository;

public class ProductService {
	private ProductRepository productRepository;

	public Product createProduct(CreateProductRequest request) {
		Product product = new Product(request.getProductName(), request.getPrice());
		productRepository.save(product);
		return product;
	}
}
