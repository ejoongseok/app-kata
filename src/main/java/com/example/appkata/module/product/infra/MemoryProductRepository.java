package com.example.appkata.module.product.infra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.appkata.module.product.domain.Product;
import com.example.appkata.module.product.domain.ProductRepository;

public class MemoryProductRepository implements ProductRepository {

	private final Map<Long, Product> persistMap = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong(1);

	@Override
	public void save(Product product) {
		product.assignId(nextId());
		persistMap.put(product.getId(), product);
	}

	private long nextId() {
		return sequence.getAndIncrement();
	}
}
