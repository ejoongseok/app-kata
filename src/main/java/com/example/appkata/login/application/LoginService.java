package com.example.appkata.login.application;

import org.springframework.stereotype.Service;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final AccountRepository accountRepository;
	private final AccountSessionManager sessionManager;
	public LoginSession login(LoginRequest request) {
		Account account = accountRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
		LoginSession loginSession = new LoginSession(account.getEmail(), account.getUsername());
		sessionManager.saveLoginUserId(account.getId());
		return loginSession;
	}

	public Account getUser() {
		Long loginUserId = sessionManager.getLoginUserId();
		return accountRepository.findById(loginUserId)
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
	}
}
