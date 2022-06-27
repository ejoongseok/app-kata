package com.example.appkata.login;

import static com.example.appkata.login.api.LoginApi.*;
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

import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.domain.Account;
import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginResponse;
import com.example.appkata.login.application.LoginSession;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class LoginApiTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;

	@Autowired
	AccountService accountService;

	@Test
	void 로그인_요청() throws Exception {
		// given
		String email = "ejoongseok@gmail.com";
		String username = "ejoongseok";
		LoginRequest request = new LoginRequest(email);

		accountService.join(new CreateAccountRequest(username, email));

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
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isNotNull();
		Assertions.assertThat(session.getAttribute(LOGIN_USER_KEY)).isInstanceOf(LoginSession.class);
	}

}
