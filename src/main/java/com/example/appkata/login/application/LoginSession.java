package com.example.appkata.login.application;

import lombok.Getter;

@Getter
public class LoginSession {
	private final String email;
	private final String username;

	public LoginSession(String email, String username) {
		this.email = email;
		this.username = username;
	}
}
