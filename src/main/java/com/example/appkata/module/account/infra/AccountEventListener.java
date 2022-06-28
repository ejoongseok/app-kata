package com.example.appkata.module.account.infra;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountEventListener {

	private final EmailSender emailSender;

	@Async
	@EventListener
	public void handleCreatedAccountEmailSendEvent(CreatedAccountEmailSendEvent event) {
		emailSender.sendEmail(event.getEmail(), event.getUsername());
	}
}
