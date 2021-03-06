package com.example.appkata.module.account.infra;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.appkata.module.account.domain.Account;
import com.example.appkata.module.account.domain.AccountRepository;

@Repository
public class MemoryAccountRepository implements AccountRepository {
	private final AtomicLong id = new AtomicLong(1);
	private final Map<Long, Account> persistentMap = new ConcurrentHashMap();

	@Override
	public void save(Account account) {
		account.assignId(nextId());
		persistentMap.put(account.getId(), account);
	}

	@Override
	public Optional<Account> findByEmail(String email) {
		return persistentMap.values()
			.stream()
			.filter(account -> account.getEmail().equals(email))
			.findFirst();
	}

	@Override
	public void deleteAll() {
		persistentMap.clear();
	}

	@Override
	public Optional<Account> findById(Long loginUserId) {
		return Optional.ofNullable(persistentMap.get(loginUserId));
	}

	@Override
	public boolean delete(Account user) {
		Account remove = persistentMap.remove(user.getId());
		return remove != null;
	}

	private Long nextId() {
		return id.getAndIncrement();
	}
}
