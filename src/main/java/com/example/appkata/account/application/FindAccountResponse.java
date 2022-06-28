package com.example.appkata.account.application;

import lombok.Getter;

@Getter
public class FindAccountResponse {
	private final String username;
	private final String email;

	public FindAccountResponse(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
