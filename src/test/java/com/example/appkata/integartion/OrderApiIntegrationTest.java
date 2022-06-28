package com.example.appkata.integartion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.example.appkata.fixture.ProductFixture;
import com.example.appkata.module.order.application.CreateOrderRequest;
import com.example.appkata.module.order.application.CreateOrderResponse;
import com.example.appkata.module.product.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class OrderApiIntegrationTest {

	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;

	@Autowired ProductFixture productFixture;

	@Test
	void 주문_요청() throws Exception {
		// given
		Product product = productFixture.createProduct("상품1", 100);
		int quantity = 10;
		CreateOrderRequest request = CreateOrderRequest.of(product.getId(),quantity);
		int expectedTotalPrice = product.getPrice() * quantity;

		// when
		MockHttpServletResponse response = mockMvc.perform(post("/orders")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		CreateOrderResponse createOrderResponse = objectMapper.readValue(response.getContentAsString(),
			CreateOrderResponse.class);
		Assertions.assertThat(createOrderResponse.getOrderId()).isPositive();
		Assertions.assertThat(createOrderResponse.getQuantity()).isEqualTo(quantity);
		Assertions.assertThat(createOrderResponse.getTotalPrice()).isEqualTo(expectedTotalPrice);
		Assertions.assertThat(createOrderResponse.getProductId()).isEqualTo(product.getId());
		Assertions.assertThat(createOrderResponse.getProductName()).isEqualTo(product.getName());
	}

	@Test
	void 주문_조회(){
		// given

		// when

		// then
	}


}
