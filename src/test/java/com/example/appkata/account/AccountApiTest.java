package com.example.appkata.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.example.appkata.account.application.CreateAccountRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AccountApiTest {

	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;

	@Test
	@DisplayName("유효하지 않은 이메일 주소를 입력하면 Bad Request 응답.")
	void should_invalid_email_join_account_return_bad_request() throws Exception {
		// given
		String username = "joongseok";
		String email = "joongseok";
		String exceptionMessage = "유효하지 않은 이메일 주소입니다.";
		CreateAccountRequest request =  new CreateAccountRequest(username, email);


		// when
		MockHttpServletResponse response = mockMvc.perform(post("/accounts")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
		AccountExceptionResponse exceptionResponse = objectMapper.readValue(response.getContentAsString(),
			AccountExceptionResponse.class);
		Assertions.assertThat(exceptionResponse.getMessage()).isEqualTo(exceptionMessage);
	}

	private static class AccountExceptionResponse {
		private String message;

		public String getMessage() {
			return message;
		}
	}
}
