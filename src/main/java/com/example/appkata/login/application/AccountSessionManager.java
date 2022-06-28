package com.example.appkata.login.application;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountSessionManager {
	private final HttpSession session;
	public static final String LOGIN_USER_KEY = "LOGIN_USER";

	public void saveLoginUserId(Long accountId) {
		session.setAttribute(LOGIN_USER_KEY, accountId);

	}
	public Long getLoginUserId() {
		return (Long)session.getAttribute(LOGIN_USER_KEY);
	}
}
