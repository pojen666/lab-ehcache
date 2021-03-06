# Lab Ehcache

## Description

Spring Boot Cache with ehcache demo project

## Packages

package| description
---|---
com.demo.config | 設定檔
com.com.demo.service | 服務類
com.com.demo.service.impl | 服務實作

## 前置作業

### Maven相依

```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <dependency>
        <groupId>net.sf.ehcache</groupId>
        <artifactId>ehcache</artifactId>
    </dependency>
</dependencies>
```

### 啟用和Cache設定實作
```java
package com.demo.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@EnableCaching
@Configuration
public class CacheConfig {

    // 從yml提取屬性
    @Resource
    private EhcacheProperties ehcacheProperties;

    @Bean
    public EhCacheCacheManager demoEhCacheManager() {
        var manager = EhCacheManagerUtils.buildCacheManager();
        manager.addCache(new Cache(new CacheConfiguration()
                .eternal(ehcacheProperties.getEternal())
                .overflowToOffHeap(ehcacheProperties.getOverflowToOffHeap())
                .timeToIdleSeconds(ehcacheProperties.getTimeToIdleSeconds())
                .timeToLiveSeconds(ehcacheProperties.getTimeToLiveSeconds())
                .maxEntriesLocalHeap(ehcacheProperties.getMaxEntriesLocalHeap())
                .name("demo")));
        return new EhCacheCacheManager(manager);
    }
}
```

## 應用

### 基礎應用
在服務上加入註釋
```java
package com.demo.service;

import org.springframework.cache.annotation.Cacheable;

public interface DemoCacheService {

    @Cacheable("demo")
    Integer plusOne();
}
```
## 效果展示

建立[單元測試](/src/test/java/com/demo/DemoCacheServiceTest.java)檢查結果是否如預期