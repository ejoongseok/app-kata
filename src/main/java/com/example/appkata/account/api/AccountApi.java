package com.example.appkata.account.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.application.CreateAccountResponse;

@RestController
@RequestMapping("/accounts")
public class AccountApi {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
		return null;
	}
}
