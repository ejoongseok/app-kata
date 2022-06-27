package com.example.appkata.account.application;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAccountRequest {
	private String username;

	@Email
	@NotBlank
	private String email;

	public CreateAccountRequest(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
