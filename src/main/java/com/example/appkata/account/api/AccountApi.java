package com.example.appkata.account.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.application.CreateAccountResponse;
import com.example.appkata.account.domain.Account;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountApi {

	private final AccountService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
		Account newAccount = service.join(request);
		return CreateAccountResponse.of(newAccount);
	}
}
