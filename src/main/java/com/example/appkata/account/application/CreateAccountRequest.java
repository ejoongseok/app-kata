package com.example.appkata.account.application;

public class CreateAccountRequest {
	private final String username;
	private final String email;

	public CreateAccountRequest(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
