package com.example.appkata.integartion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import javax.servlet.http.HttpSession;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.appkata.account.domain.Account;
import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class LoginTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;

	@Test
	void 로그인_요청() throws Exception {
		// given
		String email = "ejoongseok@gmail.com";
		String username = "ejoongseok";
		LoginRequest request = new LoginRequest(email);

		// when
		MvcResult mvcResult = mockMvc.perform(post("/login")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn();

		// then
		MockHttpServletResponse response = mvcResult.getResponse();
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		LoginResponse loginResponse = objectMapper.readValue(response.getContentAsString(), LoginResponse.class);
		Assertions.assertThat(loginResponse.getEmail()).isEqualTo(email);
		Assertions.assertThat(loginResponse.getUsername()).isEqualTo(username);

		HttpSession session = mvcResult.getRequest().getSession();
		String LOGIN_USER_KEY = "LOGIN_USER";
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isNotNull();
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isInstanceOf(Account.class);
	}

}
