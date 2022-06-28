package com.example.appkata.account.domain;

import lombok.Getter;

@Getter
public class Account {
	private Long id;
	private String username;
	private String email;

	public Account(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public void assignId(Long nextId) {
		this.id = nextId;
	}

	public void updateUsername(String username) {
		this.username = username;
	}
}
