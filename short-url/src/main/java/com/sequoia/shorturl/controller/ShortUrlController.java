package com.sequoia.shorturl.controller;

import com.sequoia.shorturl.properties.ShortUrlServiceProperties;
import com.sequoia.shorturl.service.api.IShortUrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("short-url")
@Api(tags = "短域名服务控制器")
public class ShortUrlController {

    @Autowired
    private IShortUrlService shortUrlService;

    @Autowired
    private ShortUrlServiceProperties properties;

    @PostMapping("/{originalUrl}")
    @ApiOperation(value = "生成短域名", notes = "PathVariable中传原始URL")
    public String generateShortUrl(@PathVariable @ApiParam("原始URL") String originalUrl) {
        return shortUrlService.generateShortUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    @ApiOperation(value = "根据短域名获取原始域名", notes = "PathVariable中传短域名")
    public String getOriginalUrl(@PathVariable @ApiParam("短域名") String shortUrl) {
        return shortUrlService.getOriginalUrl(shortUrl);
    }

    @GetMapping
    public String test() {
        System.out.println(properties.getCacheCapacity());
        return "lalala";
    }
}
