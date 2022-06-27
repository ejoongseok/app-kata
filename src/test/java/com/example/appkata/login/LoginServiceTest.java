package com.example.appkata.login;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;
import com.example.appkata.account.infra.MemoryAccountRepository;
import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginService;
import com.example.appkata.login.application.LoginSession;

class LoginServiceTest {

	AccountRepository accountRepository = new MemoryAccountRepository();
	LoginService loginService = new LoginService(accountRepository);

	@Test
	void 로그인() {
		// given
		String email = "ejoongseok@gmail.com";
		String expectedUsername = "ejoongseok";
		LoginRequest request = new LoginRequest(email);
		accountRepository.save(new Account(expectedUsername, email));

		// when
		LoginSession loginSession = loginService.login(request);

		// then
		Assertions.assertThat(loginSession.getEmail()).isEqualTo(email);
		Assertions.assertThat(loginSession.getUsername()).isEqualTo(expectedUsername);
	}
	@Test
	void 로그인_실패_없는_이메일() {
		// given
		String email = "ejoongseok@gmail.com";
		String expectedUsername = "ejoongseok";
		accountRepository.save(new Account(expectedUsername, "email@gmail.com"));
		LoginRequest request = new LoginRequest(email);

		// when
		Assertions.assertThatThrownBy(() -> loginService.login(request))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("Account not found");
	}

}
