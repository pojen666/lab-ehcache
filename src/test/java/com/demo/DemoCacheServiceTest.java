package com.demo;

import com.demo.service.DemoCacheService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("展示快取")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class DemoCacheServiceTest {

    @Resource
    private DemoCacheService demoCacheService;

    @DisplayName("展示呼叫10次")
    @Test
    void demo() throws InterruptedException {
        // 總共呼叫的次數
        int totalCallCount = 0;
        // 由進入服務執行取得資料的筆數
        int totalGetCacheCount = 0;
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            totalCallCount = i;
            totalGetCacheCount = demoCacheService.plusOne();
            log.info(String.format("第%s次呼叫展示方法", totalCallCount));
            log.info(String.format("取得第%s筆快取資訊%n", totalGetCacheCount));
        }
        assertThat(totalCallCount).isNotEqualTo(totalGetCacheCount);
    }
}
