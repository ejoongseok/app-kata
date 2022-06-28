package com.example.appkata.account.application;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindAccountResponse {
	private String username;
	private String email;

	public FindAccountResponse(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
