package com.example.appkata.account.application;

import org.springframework.stereotype.Service;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repository;

	public Account join(CreateAccountRequest request) {
		Account account = new Account(request.getUsername(), request.getEmail());
		repository.save(account);
		return account;
	}
}
