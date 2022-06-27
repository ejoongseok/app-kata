package com.example.appkata.account.infra;

public interface EmailSender {

	void sendEmail(String email, String username);
}
