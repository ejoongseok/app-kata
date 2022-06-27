package com.example.appkata.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class AccountApiTest {

	@Test
	@DisplayName("유효하지 않은 이메일 주소를 입력하면 Bad Request 응답.")
	void should_invalid_email_join_account_return_throw() {
		// given


		// when

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
		Assertions.assertThat(exceptionResponse.getMessage()).isEqaulTo(exceptionMessage);
	}

}
