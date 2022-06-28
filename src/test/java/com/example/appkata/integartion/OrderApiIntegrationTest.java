package com.example.appkata.integartion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class OrderApiIntegrationTest {

	@Test
	void 주문_요청() {
		// given

		// when

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		Assertions.assertThat(createOrderResponse.getOrderId()).isPositive();
		Assertions.assertThat(createOrderResponse.getQuantity()).isEqualTo(quantity);
		Assertions.assertThat(createOrderResponse.getTotalPrice()).isEqualTo(expectedTotalPrice);
		Assertions.assertThat(createOrderResponse.getProductId()).isEqualTo(product.getId());
		Assertions.assertThat(createOrderResponse.getProductName()).isEqualTo(product.getName());
	}

}
