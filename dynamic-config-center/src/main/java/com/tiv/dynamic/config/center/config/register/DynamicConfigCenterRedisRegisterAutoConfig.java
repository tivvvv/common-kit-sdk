package com.tiv.dynamic.config.center.config.register;

import com.tiv.dynamic.config.center.config.DynamicConfigCenterProperties;
import com.tiv.dynamic.config.center.domain.service.DynamicConfigCenterService;
import com.tiv.dynamic.config.center.domain.service.impl.DynamicConfigCenterServiceImpl;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {DynamicConfigCenterRedisRegisterProperties.class})
public class DynamicConfigCenterRedisRegisterAutoConfig {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterRedisRegisterAutoConfig.class);

    @Bean("dynamicConfigCenterRedissonClient")
    public RedissonClient redissonClient(DynamicConfigCenterRedisRegisterProperties properties) {
        Config config = new Config();
        config.setCodec(JsonJacksonCodec.INSTANCE);

        config.useSingleServer()
                .setAddress(String.format("redis://%s:%s", properties.getHost(), properties.getPort()))
                .setPassword(properties.getPassword())
                .setConnectionPoolSize(properties.getPoolSize())
                .setConnectionMinimumIdleSize(properties.getMinIdleSize())
                .setIdleConnectionTimeout(properties.getIdleTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setRetryAttempts(properties.getRetryAttempts())
                .setRetryInterval(properties.getRetryInterval())
                .setPingConnectionInterval(properties.getPingInterval())
                .setKeepAlive(properties.isKeepAlive())
        ;

        RedissonClient redissonClient = Redisson.create(config);

        log.info("动态配置中心初始化redis连接成功");
        return redissonClient;
    }

    @Bean("dynamicConfigCenterService")
    public DynamicConfigCenterService dynamicConfigCenterService(DynamicConfigCenterProperties properties, RedissonClient dynamicConfigCenterRedissonClient) {
        return new DynamicConfigCenterServiceImpl(properties, dynamicConfigCenterRedissonClient);
    }

}