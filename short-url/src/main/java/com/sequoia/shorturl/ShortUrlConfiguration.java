package com.sequoia.shorturl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ShortUrlConfiguration {

    @Bean
    public Cache<String, String> urlCache() {
        return CacheBuilder.newBuilder()
                .concurrencyLevel(10)
                .expireAfterWrite(365, TimeUnit.DAYS)
                .build();
    }
}
