package com.example.appkata.account.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;
import com.example.appkata.account.infra.CreatedAccountEmailSendEvent;
import com.example.appkata.login.application.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repository;
	private final LoginService loginService;

	private final ApplicationEventPublisher publisher;


	public Account join(CreateAccountRequest request) {
		Account account = new Account(request.getUsername(), request.getEmail());
		repository.save(account);
		publisher.publishEvent(new CreatedAccountEmailSendEvent(account.getEmail(), account.getUsername()));
		return account;
	}

	public Account updateUsername(UpdateAccountRequest request) {
		Account user = loginService.getUser();
		user.updateUsername(request.getUsername());
		return new Account(user.getUsername(), user.getEmail());
	}

	public boolean removeUser() {
		Account user = loginService.getUser();
		return repository.delete(user);
	}

	public Account getUser() {
		return null;
	}
}
