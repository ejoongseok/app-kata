package com.example.appkata.account.application;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;
import com.example.appkata.account.infra.MemoryAccountRepository;

public class AccountService {
	private AccountRepository repository = new MemoryAccountRepository();

	public Account join(CreateAccountRequest request) {
		Account account = new Account(request.getUsername(), request.getEmail());
		repository.save(account);
		return account;
	}
}
