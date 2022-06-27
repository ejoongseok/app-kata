package com.example.appkata.login.application;

import static com.example.appkata.login.api.LoginApi.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final AccountRepository accountRepository;
	private final HttpSession session;
	public LoginSession login(LoginRequest request) {
		Account account = accountRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
		LoginSession loginSession = new LoginSession(account.getEmail(), account.getUsername());
		session.setAttribute(LOGIN_USER_KEY, loginSession);
		return loginSession;
	}
}
