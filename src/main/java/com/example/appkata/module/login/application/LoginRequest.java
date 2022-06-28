package com.example.appkata.module.login.application;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
	private String email;

	public LoginRequest(String email) {
		this.email = email;
	}
}
