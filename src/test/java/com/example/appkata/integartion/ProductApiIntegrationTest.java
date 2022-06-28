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

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.CreateProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProductApiIntegrationTest {

	@Autowired ObjectMapper objectMapper;
	@Autowired MockMvc mockMvc;

	@Test
	void 상품_등록() throws Exception {
		// given
		String productName = "노트북";
		int price = 1_000_000;
		CreateProductRequest request = CreateProductRequest.of(productName, price);

		// when
		MockHttpServletResponse response = mockMvc.perform(post("/products")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		CreateProductResponse createProductResponse = objectMapper.readValue(response.getContentAsString(),
			CreateProductResponse.class);
		Assertions.assertThat(createProductResponse.getId()).isPositive();
		Assertions.assertThat(createProductResponse.getProductName()).isEqualTo(productName);
		Assertions.assertThat(createProductResponse.getPrice()).isEqualTo(price);
	}

}
