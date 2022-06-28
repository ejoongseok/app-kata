package com.example.appkata.module.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

	@Test
	void 상품_주문() {
		// given

		// when

		// then
		Assertions.assertThat(order.getId()).isPositive();
		Assertions.assertThat(order.getProductId()).isEqualTo(productId);
		Assertions.assertThat(order.getProductName()).isEqualTo(productName);
		Assertions.assertThat(order.getQuantity()).isEqualTo(quantity);
		Assertions.assertThat(order.getTotalPrice()).isEqualTo(totalPrice);

	}

}
