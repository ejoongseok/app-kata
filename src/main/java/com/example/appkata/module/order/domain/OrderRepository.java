package com.example.appkata.module.order.domain;

import java.util.Optional;

public interface OrderRepository {
	void save(Order order);

	Optional<Order> findById(long orderId);
}
