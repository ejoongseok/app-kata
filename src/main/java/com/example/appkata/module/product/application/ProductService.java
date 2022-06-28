package com.example.appkata.module.product.application;

import java.util.Optional;

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

	public Product updateProduct(UpdateProductRequest request) {
		Product product = productRepository.findById(request.getId())
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));

		product.update(request.getProductName(), request.getPrice());

		return product;
	}
}
