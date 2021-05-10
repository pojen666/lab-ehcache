package com.demo.service.impl;

import com.demo.service.DemoCacheService;
import org.springframework.stereotype.Service;

@Service
public class DemoCacheServiceImpl implements DemoCacheService {

    private Integer count = 0;

    @Override
    public Integer plusOne() {
        return ++count;
    }
}
