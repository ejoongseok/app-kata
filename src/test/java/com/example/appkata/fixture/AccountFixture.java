package com.example.appkata.fixture;

import org.springframework.stereotype.Component;

import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.domain.Account;

@Component
public class AccountFixture {
	private final AccountService accountService;
	public static final String FIXTURE_USER_NAME = "ejoongseok";
	public static final String FIXTURE_USER_EMAIL = "ejoongseok@gmail.com";

	public AccountFixture(AccountService accountService) {
		this.accountService = accountService;
	}

	public Account createAccount() {
		return accountService.join(new CreateAccountRequest(FIXTURE_USER_NAME, FIXTURE_USER_EMAIL));
	}
}
