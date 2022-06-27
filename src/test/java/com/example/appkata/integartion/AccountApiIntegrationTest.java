package com.example.appkata.integartion;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.application.CreateAccountResponse;
import com.example.appkata.account.infra.EmailSender;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AccountApiIntegrationTest {

	@Autowired ObjectMapper objectMapper;
	@Autowired MockMvc mockMvc;
	@MockBean
	EmailSender emailSender;

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

		verify(emailSender, times(1)).sendEmail(email, username);
	}

}
