package com.example.appkata.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.io.UnsupportedEncodingException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

class AccountApiTest {

	@Test
	@DisplayName("유효하지 않은 이메일 주소를 입력하면 Bad Request 응답.")
	void should_invalid_email_join_account_return_throw() throws Exception {
		// given


		// when
		MockHttpServletResponse response = mockMvc.perform(post("/accounts")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
		AccountExceptionResponse exceptionResponse = objectMapper.readValue(response.getContentAsString(),
			AccountExceptionResponse.class);
		Assertions.assertThat(exceptionResponse.getMessage()).isEqaulTo(exceptionMessage);
	}

}
