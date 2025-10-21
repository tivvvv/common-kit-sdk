package com.tiv.rule.tree.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    /**
     * 创建线程池
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                ThreadPoolProperties.CORE_POOL_SIZE,
                ThreadPoolProperties.MAX_POOL_SIZE,
                ThreadPoolProperties.KEEP_ALIVE_TIME,
                ThreadPoolProperties.TIME_UNIT,
                new LinkedBlockingDeque<>(ThreadPoolProperties.BLOCKING_QUEUE_CAPACITY),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
