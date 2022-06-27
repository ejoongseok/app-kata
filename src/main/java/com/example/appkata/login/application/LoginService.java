package com.example.appkata.login.application;

import org.springframework.stereotype.Service;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final AccountRepository accountRepository;
	public LoginSession login(LoginRequest request) {
		Account account = accountRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
		return new LoginSession(account.getEmail(), account.getUsername());
	}
}
