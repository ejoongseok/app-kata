package com.example.appkata.account.infra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.appkata.account.domain.Account;
import com.example.appkata.account.domain.AccountRepository;

@Repository
public class MemoryAccountRepository implements AccountRepository {
	private final AtomicLong id = new AtomicLong(1);
	private final Map<Long, Account> persistentMap = new ConcurrentHashMap();

	@Override
	public void save(Account account) {
		account.assignId(nextId());
		persistentMap.put(account.getId(), account);
	}

	private Long nextId() {
		return id.getAndIncrement();
	}
}