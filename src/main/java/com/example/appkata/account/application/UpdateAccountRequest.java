package com.example.appkata.account.application;

import lombok.Getter;

@Getter
public class UpdateAccountRequest {
	private final String username;
	public UpdateAccountRequest(String expectedUsername) {
		this.username = expectedUsername;
	}
}
