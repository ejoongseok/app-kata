package com.example.appkata.account.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAccountRequest {
	private String username;
	private String email;

	public CreateAccountRequest(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
