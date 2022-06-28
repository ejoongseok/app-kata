package com.example.appkata.common.config;

import static com.example.appkata.common.config.CacheConfig.AppCacheTypeConstant.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

import lombok.Getter;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		List<CaffeineCache> caches = Arrays.stream(AppCacheType.values())
			.map(cache -> new CaffeineCache(cache.getCacheName(), Caffeine.newBuilder().recordStats()
					.expireAfterWrite(cache.getExpireAfterWrite(), TimeUnit.SECONDS)
					.maximumSize(cache.getMaximumSize())
					.build()
				)
			)
			.toList();

		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(caches);

		return cacheManager;
	}


	public static final class AppCacheTypeConstant {
		public static final String FIND_USER_CACHE = "findUser";
	}

	@Getter
	public enum AppCacheType {
		FIND_USER(
				FIND_USER_CACHE,
				60 * 60 * 24, // 하루
				100
			);

		AppCacheType(String cacheName, int expireAfterWrite, int maximumSize) {
			this.cacheName = cacheName;
			this.expireAfterWrite = expireAfterWrite;
			this.maximumSize = maximumSize;
		}
		private final String cacheName;
		private final int expireAfterWrite;
		private final int maximumSize;
	}
}
