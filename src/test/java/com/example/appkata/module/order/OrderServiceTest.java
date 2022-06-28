package com.example.appkata.module.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.appkata.fixture.ProductFixture;
import com.example.appkata.module.order.application.CreateOrderRequest;
import com.example.appkata.module.order.application.OrderService;
import com.example.appkata.module.order.domain.Order;
import com.example.appkata.module.product.domain.Product;

class OrderServiceTest {

	ProductFixture productFixture;
	OrderService orderService;

	@Test
	void 상품_주문() {
		// given
		Product product = productFixture.createProduct("상품1", 100);

		long productId = product.getId();
		int quantity = 10;
		int totalPrice = product.getPrice() * quantity;
		CreateOrderRequest request = CreateOrderRequest.of(productId, quantity);

		// when
		Order order = orderService.order(request);

		// then
		Assertions.assertThat(order.getId()).isPositive();
		Assertions.assertThat(order.getProduct().getId()).isEqualTo(productId);
		Assertions.assertThat(order.getProduct().getName()).isEqualTo(product.getName());
		Assertions.assertThat(order.getQuantity()).isEqualTo(quantity);
		Assertions.assertThat(order.getTotalPrice()).isEqualTo(totalPrice);

	}

}
