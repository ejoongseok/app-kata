package com.example.appkata.module.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.appkata.module.product.application.CreateProductRequest;

class ProductServiceTest {

	private ProductService productService;

	@Test
	@DisplayName("상품 등록")
	void create_product_test() {
		// given
		String productName = "노트북";
		int price = 1_000_000;
		CreateProductRequest request = CreateProductRequest.of(productName, price);
		// when
		Product product = productService.createProduct(request);
		// then
		Assertions.assertThat(product.getId()).isPositive();
		Assertions.assertThat(product.getName()).isEqualTo(productName);
		Assertions.assertThat(product.getPrice()).isEqualTo(price);

	}

	private static class Product {
		private Long id;
		private String name;
		private int price;

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}
	}

	private class ProductService {
		public Product createProduct(CreateProductRequest request) {
			return null;
		}
	}
}
