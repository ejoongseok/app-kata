package com.example.appkata.integartion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProductApiIntegrationTest {


	@Test
	void 상품_등록() {
		// given

		// when

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		Assertions.assertThat(createProductResponse.getId()).isPositive();
		Assertions.assertThat(createProductResponse.getProductName()).isEqualTo(productName);
		Assertions.assertThat(createProductResponse.getPrice()).isEqualTo(price);
	}

}
