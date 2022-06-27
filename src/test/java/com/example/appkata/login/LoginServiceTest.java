package com.example.appkata.login;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginServiceTest {

	@Test
	void 로그인() {
		// given

		// when

		// then
		Assertions.assertThat(loginSession.getEmail()).isEqualTo(email);
		Assertions.assertThat(loginSession.getUsername()).isEqualTo(username);
	}

}
