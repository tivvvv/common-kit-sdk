package com.tiv.dynamic.config.center.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DynamicConfigCenterProperties.class)
public class DynamicConfigCenterAutoConfig implements BeanPostProcessor {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterAutoConfig.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
