package com.sequoia.shorturl.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "short-url")
public class ShortUrlServiceProperties {

    private int cacheCapacity = 100;
}
