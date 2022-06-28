package com.example.appkata.module.order.infra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.appkata.module.order.domain.Order;
import com.example.appkata.module.order.domain.OrderRepository;

@Repository
public class MemoryOrderRepository implements OrderRepository {

	private final Map<Long, Order> persistMap = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong(1);

	@Override
	public void save(Order order) {
		order.assignId(nextId());
		persistMap.put(order.getId(), order);
	}

	private long nextId() {
		return sequence.getAndIncrement();
	}
}
