package com.example.appkata.module.account.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.appkata.module.account.domain.Account;
import com.example.appkata.module.account.domain.AccountRepository;
import com.example.appkata.module.account.infra.CreatedAccountEmailSendEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repository;
	private final AccountSessionManager sessionManager;
	private final ApplicationEventPublisher publisher;


	public Account join(CreateAccountRequest request) {
		Account account = new Account(request.getUsername(), request.getEmail());
		repository.save(account);
		publisher.publishEvent(new CreatedAccountEmailSendEvent(account.getEmail(), account.getUsername()));
		return account;
	}

	public Account updateUsername(UpdateAccountRequest request) {
		Account user = getUser();
		user.updateUsername(request.getUsername());
		return new Account(user.getUsername(), user.getEmail());
	}

	public boolean removeUser() {
		Account user = getUser();
		return repository.delete(user);
	}

	public Account getUser() {
		Long loginUserId = sessionManager.getLoginUserId();
		return repository.findById(loginUserId)
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
	}
}
