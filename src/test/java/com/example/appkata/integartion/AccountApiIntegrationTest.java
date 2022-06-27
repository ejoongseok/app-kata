package com.example.appkata.integartion;

import java.awt.image.PixelGrabber;
import java.io.UnsupportedEncodingException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

class AccountApiIntegrationTest {

	ObjectMapper objectMapper;

	@Test
	void 회원_등록_요청() throws Exception {
		// given
		String username = "joongseok";
		String email = "ejoongseok@gamil.com";

		// when
		MockHttpServletResponse response = null;

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		CreateAccountResponse createAccountResponse = objectMapper.readValue(response.getContentAsString(),
			CreateAccountResponse.class);
		Assertions.assertThat(createAccountResponse.getId()).isPositive();
		Assertions.assertThat(createAccountResponse.getName()).isEqualTo(username);
		Assertions.assertThat(createAccountResponse.getEmail()).isEqualTo(email);
	}


	private static class CreateAccountResponse {
		private long id;
		private String name;
		private String email;

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}
	}
}
