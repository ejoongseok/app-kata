package com.example.appkata.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.domain.Account;

@SpringBootTest
class AccountServiceTest {

	@Autowired AccountService accountService;

	@Test
	@DisplayName("사용자 정보 등록")
	void join_account_test() {
		// given
		String username = "joongseok";
		String email = "ejoongseok@gamil.com";
		CreateAccountRequest request = new CreateAccountRequest(username, email);

		// when
		Account account = accountService.join(request);

		// then
		Assertions.assertThat(account.getId()).isPositive();
		Assertions.assertThat(account.getUsername()).isEqualTo(username);
		Assertions.assertThat(account.getEmail()).isEqualTo(email);
	}

}
