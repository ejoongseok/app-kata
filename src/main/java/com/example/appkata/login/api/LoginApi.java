package com.example.appkata.login.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginResponse;
import com.example.appkata.login.application.LoginService;
import com.example.appkata.login.application.LoginSession;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginApi {

	private final LoginService loginService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		LoginSession user = loginService.login(request);
		return new LoginResponse(user.getEmail(), user.getUsername());
	}
}
