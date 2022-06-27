package com.example.appkata.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountServiceTest {

	@Test
	@DisplayName("사용자 정보 등록")
	void join_account_test() {
		// given

		// when
		Account account = accountService.join(request);

		// then
		Assertions.assertThat(account.getId()).isPositive();
		Assertions.assertThat(account.getUsername()).isEqualTo(username);
		Assertions.assertThat(account.getEmail()).isEqualTo(email);
	}

}
