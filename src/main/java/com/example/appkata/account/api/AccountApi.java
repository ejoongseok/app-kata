package com.example.appkata.account.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.account.application.AccountExceptionResponse;
import com.example.appkata.account.application.AccountService;
import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.application.CreateAccountResponse;
import com.example.appkata.account.application.UpdateAccountRequest;
import com.example.appkata.account.application.UpdateAccountResponse;
import com.example.appkata.account.domain.Account;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountApi {

	private final AccountService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAccountResponse createAccount(@RequestBody @Valid CreateAccountRequest request) {
		Account newAccount = service.join(request);
		return CreateAccountResponse.of(newAccount);
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public UpdateAccountResponse updateAccount(@RequestBody UpdateAccountRequest request) {
		Account account = service.updateUsername(request);
		return new UpdateAccountResponse(account.getUsername());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AccountExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		return new AccountExceptionResponse(e.getMessage());
	}
}
