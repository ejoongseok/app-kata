package com.example.appkata.account.application;

import com.example.appkata.account.domain.Account;

public class AccountService {
	public Account join(CreateAccountRequest request) {
		return new Account(request.getUsername(), request.getEmail());
	}
}
