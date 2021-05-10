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
