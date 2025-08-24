package com.tiv.dynamic.config.center.types.annotation;

import java.lang.annotation.*;

/**
 * 动态配置中心注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DynamicConfigCenterValue {

    String value() default "";

}
