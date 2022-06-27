package com.example.appkata.login;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginService;
import com.example.appkata.login.application.LoginSession;

class LoginServiceTest {

	private LoginService loginService;

	@Test
	void 로그인() {
		// given
		String email = "ejoongseok@gmail.com";
		String expectedUsername = "ejoongseok";
		LoginRequest request = new LoginRequest(email);

		// when
		LoginSession loginSession = loginService.login(request);

		// then
		Assertions.assertThat(loginSession.getEmail()).isEqualTo(email);
		Assertions.assertThat(loginSession.getUsername()).isEqualTo(expectedUsername);
	}

}
