package com.sequoia.shorturl.service.impl;

import com.google.common.cache.Cache;
import com.sequoia.shorturl.service.api.IShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShortUrlService implements IShortUrlService {

    private static final int SHORT_URL_LENGTH = 8;
    private static final char[] URL_SYMBOLS = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//            '-', '_', '.', '~', '!', '*', '\'', '(', ')', ';', ':', '@', '&', '=', '+', '$', ',', '?', '#', '[', ']'
    };
    private static final Random RANDOM = new Random();
    @Autowired
    private Cache<String, String> urlCache;

    @Override
    public String generateShortUrl(String originalUrl) {
        String shortUrl = getRandomUrl();
        urlCache.put(shortUrl, originalUrl);
        return shortUrl;
    }

    private String getRandomUrl() {
        StringBuilder shortUrlBuilder = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrlBuilder.append(URL_SYMBOLS[RANDOM.nextInt(URL_SYMBOLS.length)]);
        }
        return shortUrlBuilder.toString();
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        return urlCache.getIfPresent(shortUrl);
    }
}
