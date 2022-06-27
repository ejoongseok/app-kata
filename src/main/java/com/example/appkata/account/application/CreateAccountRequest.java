package com.example.appkata.account.application;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAccountRequest {
	private String username;

	@Email(message = "올바른 이메일 형식이 아닙니다.")
	@NotBlank
	private String email;

	public CreateAccountRequest(String username, String email) {
		this.username = username;
		this.email = email;
	}
}
