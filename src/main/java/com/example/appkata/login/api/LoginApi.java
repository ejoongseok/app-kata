package com.example.appkata.login.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.login.application.LoginRequest;
import com.example.appkata.login.application.LoginResponse;

@RestController
public class LoginApi {

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return null;
	}
}
