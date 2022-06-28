package com.example.appkata.account.application;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateAccountResponse {
	private String name;

	public UpdateAccountResponse(String username) {
		this.name = username;
	}
}
