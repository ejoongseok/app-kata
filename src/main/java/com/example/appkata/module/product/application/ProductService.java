package com.example.appkata.module.product.application;

import org.springframework.stereotype.Service;

import com.example.appkata.module.product.domain.Product;
import com.example.appkata.module.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public Product createProduct(CreateProductRequest request) {
		Product product = new Product(request.getProductName(), request.getPrice());
		productRepository.save(product);
		return product;
	}
}
