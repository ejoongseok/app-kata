package com.example.appkata.integartion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class AccountApiIntegrationTest {

	@Test
	void 회원_등록_요청() {
		// given

		// when

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		Assertions.assertThat(createAccountResponse.getId()).isPositive();
		Assertions.assertThat(createAccountResponse.getName()).isEqualTo(username);
		Assertions.assertThat(createAccountResponse.getEmail()).isEqualTo(email);
	}

}
