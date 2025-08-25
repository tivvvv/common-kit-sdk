package com.tiv.dynamic.config.center.config;

import com.tiv.dynamic.config.center.domain.service.DynamicConfigCenterService;
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

    private final DynamicConfigCenterService dynamicConfigCenterService;

    public DynamicConfigCenterAutoConfig(DynamicConfigCenterService dynamicConfigCenterService) {
        this.dynamicConfigCenterService = dynamicConfigCenterService;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return dynamicConfigCenterService.initializeDynamicConfigBean(bean);
    }

}
