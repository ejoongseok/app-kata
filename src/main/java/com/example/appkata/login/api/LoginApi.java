package com.example.appkata.login.api;

import javax.servlet.http.HttpSession;

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
	public static final String LOGIN_USER_KEY = "LOGIN_USER";

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {
		LoginSession user = loginService.login(request);
		session.setAttribute(LOGIN_USER_KEY, user);
		return new LoginResponse(user.getEmail(), user.getUsername());
	}
}
