package com.sequoia.shorturl.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

@Data
@ConfigurationProperties(prefix = "short-url")
public class ShortUrlServiceProperties {

    private long cacheCapacity = 10000;

    private int cacheConcurrentLevel = 10;

    private long expireDuration = 365;

    private TimeUnit expireUnit = TimeUnit.DAYS;
}
