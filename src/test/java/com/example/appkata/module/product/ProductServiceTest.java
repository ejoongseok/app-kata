package com.example.appkata.module.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

	@Test
	@DisplayName("상품 등록")
	void create_product_test() {
		// given

		// when

		// then
		Assertions.assertThat(product.getId()).isPositive();
		Assertions.assertThat(product.getName()).isEqualTo(productName);
		Assertions.assertThat(product.getPrice()).isEqualTo(price);

	}

}
