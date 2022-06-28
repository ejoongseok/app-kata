package com.example.appkata.login;

import static com.example.appkata.fixture.AccountFixture.*;
import static com.example.appkata.login.application.AccountSessionManager.*;
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

import com.example.appkata.fixture.AccountFixture;
import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class LoginApiTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;

	@Autowired
	AccountFixture accountFixture;

	@Test
	void 로그인_요청() throws Exception {
		// given
		accountFixture.createAccount();
		LoginRequest request = new LoginRequest(FIXTURE_USER_EMAIL);


		// when
		MvcResult mvcResult = mockMvc.perform(post("/login")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn();

		// then
		MockHttpServletResponse response = mvcResult.getResponse();
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		LoginResponse loginResponse = objectMapper.readValue(response.getContentAsString(), LoginResponse.class);
		Assertions.assertThat(loginResponse.getEmail()).isEqualTo(FIXTURE_USER_EMAIL);
		Assertions.assertThat(loginResponse.getUsername()).isEqualTo(FIXTURE_USER_NAME);

		HttpSession session = mvcResult.getRequest().getSession();
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isNotNull();
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isInstanceOf(Long.class);
	}

}
