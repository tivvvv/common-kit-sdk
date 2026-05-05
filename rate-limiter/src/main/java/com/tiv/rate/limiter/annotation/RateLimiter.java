package com.tiv.rate.limiter.annotation;

import java.lang.annotation.*;

/**
 * 限流注解
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {

    /**
     * 限流字段标识: 支持按业务字段隔离限流
     * 默认不区分字段, 接口所有请求共享同一限流窗口
     */
    String limitField() default "_all";

    /**
     * 每秒最大请求许可数: 0.5表示每2s允许最多1次调用
     */
    double permitsPerSecond();

    /**
     * 黑名单触发阈值: 同一limitField连续触发限流后将被拉黑, 0表示不启用黑名单
     */
    long blacklistThreshold() default 0L;

    /**
     * 限流后执行的降级方法名
     */
    String fallbackMethod();

}