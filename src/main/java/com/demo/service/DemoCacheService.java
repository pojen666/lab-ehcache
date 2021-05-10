package com.demo.service;

import org.springframework.cache.annotation.Cacheable;

public interface DemoCacheService {

    @Cacheable("demo")
    Integer plusOne();
}
