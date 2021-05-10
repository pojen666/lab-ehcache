package com.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ehcache")
public class EhcacheProperties {

    /**
     * 是否永不過期
     */
    private Boolean eternal;

    /**
     * 是否允許物件被寫入到Heap
     */
    private Boolean overflowToOffHeap;

    /**
     * 最大的發呆時間
     */
    private Integer timeToIdleSeconds;

    /**
     * 最大的存活時間
     */
    private Integer timeToLiveSeconds;

    /**
     * 快取屬性上限
     */
    private Integer maxEntriesLocalHeap;
}
