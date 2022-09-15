package com.sequoia.shorturl.service.api;

public interface IShortUrlService {

    String generateShortUrl(String originalUrl);

    String getOriginalUrl(String shortUrl);
}
