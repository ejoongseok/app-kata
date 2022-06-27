package com.example.appkata.integartion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

class AccountApiIntegrationTest {

	ObjectMapper objectMapper;
	MockMvc mockMvc;

	@Test
	void 회원_등록_요청() throws Exception {
		// given
		String username = "joongseok";
		String email = "ejoongseok@gamil.com";
		CreateAccountRequest request = new CreateAccountRequest(username, email);

		// when
		MockHttpServletResponse response = mockMvc.perform(post("/accounts")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

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

	private static class CreateAccountRequest {
		private final String username;
		private final String email;

		public CreateAccountRequest(String username, String email) {
			this.username = username;
			this.email = email;
		}
	}
}
