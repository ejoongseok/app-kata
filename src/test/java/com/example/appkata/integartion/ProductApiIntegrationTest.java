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
import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.CreateProductResponse;
import com.example.appkata.module.product.application.UpdateProductRequest;
import com.example.appkata.module.product.application.UpdateProductResponse;
import com.example.appkata.module.product.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProductApiIntegrationTest {

	@Autowired ObjectMapper objectMapper;
	@Autowired MockMvc mockMvc;

	@Autowired ProductFixture productFixture;

	@Test
	void 상품_등록_요청() throws Exception {
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

	@Test
	void 상품_수정_요청() throws Exception {
		// given
		String oldProductName = "노트북";
		int oldPrice = 1_000_000;
		Product product = productFixture.createProduct(oldProductName, oldPrice);

		Long productId = product.getId();
		String newProductName = "노트북2";
		int newPrice = 2_000_000;
		UpdateProductRequest request = UpdateProductRequest.of(productId, newProductName, newPrice);

		// when
		MockHttpServletResponse response = mockMvc.perform(put("/products/{id}", productId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		UpdateProductResponse updateProductResponse = objectMapper.readValue(response.getContentAsString(), UpdateProductResponse.class);
		Assertions.assertThat(updateProductResponse.getId()).isEqualTo(productId);
		Assertions.assertThat(updateProductResponse.getProductName()).isEqualTo(newProductName);
		Assertions.assertThat(updateProductResponse.getPrice()).isEqualTo(newPrice);
	}

	@Test
	void 상품_조회_요청() {
		// given

		// when

		// then
	}

}
