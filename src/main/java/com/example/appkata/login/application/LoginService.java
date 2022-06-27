package com.example.appkata.login.application;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;
import com.example.appkata.account.infra.MemoryAccountRepository;

public class LoginService {
	private AccountRepository accountRepository = new MemoryAccountRepository();
	public LoginSession login(LoginRequest request) {
		Account account = accountRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
		return new LoginSession(account.getEmail(), account.getUsername());
	}
}
