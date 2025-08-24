package com.tiv.dynamic.config.center.config.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {DynamicConfigCenterRedisRegisterProperties.class})
public class DynamicConfigCenterRedisRegisterAutoConfig {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterRedisRegisterAutoConfig.class);

}