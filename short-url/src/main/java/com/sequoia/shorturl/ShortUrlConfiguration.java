package com.sequoia.shorturl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sequoia.shorturl.properties.ShortUrlServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ShortUrlConfiguration {

    @Autowired
    private ShortUrlServiceProperties properties;

    @Bean
    public Cache<String, String> urlCache() {
        return CacheBuilder.newBuilder()
                .maximumSize(properties.getCacheCapacity())
                .concurrencyLevel(properties.getCacheConcurrentLevel())
                .expireAfterWrite(properties.getExpireDuration(), properties.getExpireUnit())
                .build();
    }
}
