package com.example.appkata.account.application;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

public class AccountService {
	private AccountRepository repository;

	public Account join(CreateAccountRequest request) {
		Account account = new Account(request.getUsername(), request.getEmail());
		repository.save(account);
		return account;
	}
}
