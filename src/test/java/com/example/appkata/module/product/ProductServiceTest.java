package com.example.appkata.module.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.ProductService;
import com.example.appkata.module.product.domain.Product;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	ProductService productService;

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

}
