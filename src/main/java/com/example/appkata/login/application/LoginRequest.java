package com.example.appkata.login.application;

import lombok.Getter;

@Getter
public class LoginRequest {
	private String email;

	public LoginRequest(String email) {
		this.email = email;
	}
}
