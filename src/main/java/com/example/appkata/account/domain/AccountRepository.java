package com.example.appkata.account.domain;

import java.util.Optional;

public interface AccountRepository {
	void save(Account account);

	Optional<Account> findByEmail(String email);

	void deleteAll();
}
