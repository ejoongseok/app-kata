package com.example.appkata.module.product.application;

import com.example.appkata.module.product.domain.Product;
import com.example.appkata.module.product.domain.ProductRepository;
import com.example.appkata.module.product.infra.MemoryProductRepository;

public class ProductService {
	private ProductRepository productRepository = new MemoryProductRepository();

	public Product createProduct(CreateProductRequest request) {
		Product product = new Product(request.getProductName(), request.getPrice());
		productRepository.save(product);
		return product;
	}
}
