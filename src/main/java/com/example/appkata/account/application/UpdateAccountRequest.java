package com.example.appkata.account.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateAccountRequest {
	private String username;
	public UpdateAccountRequest(String expectedUsername) {
		this.username = expectedUsername;
	}
}
