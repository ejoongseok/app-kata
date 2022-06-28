package com.example.appkata.module.account.domain;

import java.util.Optional;

public interface AccountRepository {
	void save(Account account);

	Optional<Account> findByEmail(String email);

	void deleteAll();

	Optional<Account> findById(Long loginUserId);

	boolean delete(Account user);
}
