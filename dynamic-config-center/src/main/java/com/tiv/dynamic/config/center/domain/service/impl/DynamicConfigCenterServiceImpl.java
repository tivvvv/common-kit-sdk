package com.tiv.dynamic.config.center.domain.service.impl;

import com.tiv.dynamic.config.center.config.DynamicConfigCenterProperties;
import com.tiv.dynamic.config.center.domain.model.Attribute;
import com.tiv.dynamic.config.center.domain.service.DynamicConfigCenterService;
import com.tiv.dynamic.config.center.types.annotation.DynamicConfigCenterValue;
import com.tiv.dynamic.config.center.types.common.Constants;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态配置中心服务实现
 */
public class DynamicConfigCenterServiceImpl implements DynamicConfigCenterService {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterService.class);

    private final DynamicConfigCenterProperties properties;

    private final RedissonClient redissonClient;

    private final Map<String, Object> dynamicConfigCenterBeanMap = new ConcurrentHashMap<>();

    public DynamicConfigCenterServiceImpl(DynamicConfigCenterProperties properties, RedissonClient redissonClient) {
        this.properties = properties;
        this.redissonClient = redissonClient;
    }

    @Override
    public Object initializeDynamicConfigBean(Object bean) {
        Class<?> targetBeanClass = bean.getClass();
        Object targetBeanInstance = bean;

        // 判断bean是否是Spring代理对象
        if (AopUtils.isAopProxy(bean)) {
            // 获取被代理的bean对象
            targetBeanClass = AopUtils.getTargetClass(bean);
            targetBeanInstance = AopProxyUtils.getSingletonTarget(bean);
        }

        // 获取目标类所有字段
        Field[] fields = targetBeanClass.getDeclaredFields();
        for (Field field : fields) {
            // 跳过不含@DynamicConfigCenterValue注解的字段
            if (!field.isAnnotationPresent(DynamicConfigCenterValue.class)) {
                continue;
            }

            DynamicConfigCenterValue dynamicConfigCenterValue = field.getAnnotation(DynamicConfigCenterValue.class);

            // 校验注解的value格式 key:value
            String value = dynamicConfigCenterValue.value();
            if (StringUtils.isBlank(value)) {
                throw new RuntimeException(String.format("字段%s的@DynamicConfigCenterValue value为空", field.getName()));
            }
            String[] split = value.split(Constants.SPLIT_SYMBOL);
            if (split.length != 2) {
                throw new RuntimeException(String.format("字段%s的@DynamicConfigCenterValue value格式错误", field.getName()));
            }

            // redis key
            String key = properties.getKey(split[0].trim());
            // 默认值
            String defaultValue = split[1].trim();
            // 需要设置的值,初始值为默认值
            String setValue = defaultValue;

            try {
                // 从redis获取指定key的值
                RBucket<String> bucket = redissonClient.getBucket(key);
                boolean exists = bucket.isExists();
                if (!exists) {
                    // key不存在,使用默认值初始化
                    bucket.set(defaultValue);
                } else {
                    // key存在,使用缓存的值
                    setValue = bucket.get();
                }
                // 反射设置字段值
                field.setAccessible(true);
                field.set(targetBeanInstance, setValue);
                field.setAccessible(false);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 缓存bean对象
            dynamicConfigCenterBeanMap.put(key, targetBeanInstance);
        }
        // 返回传入的代理对象
        return bean;
    }

    @Override
    public void adjustAttribute(Attribute attribute) {
        String key = properties.getKey(attribute.getAttribute());
        String value = attribute.getValue();

        RBucket<Object> bucket = redissonClient.getBucket(key);
        boolean exists = bucket.isExists();
        if (!exists) {
            return;
        }
        // 更新redis缓存的值
        bucket.set(value);

        Object beanInstance = dynamicConfigCenterBeanMap.get(key);
        if (beanInstance == null) {
            return;
        }

        // 判断beanInstance是否是Spring代理对象
        Class<?> beanClass = beanInstance.getClass();
        if (AopUtils.isAopProxy(beanInstance)) {
            beanClass = AopUtils.getTargetClass(beanInstance);
        }

        try {
            // 反射设置字段值
            Field field = beanClass.getDeclaredField(attribute.getAttribute());
            field.setAccessible(true);
            field.set(beanInstance, value);
            field.setAccessible(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("动态配置中心节点监听, 动态设置key:{}, value:{}", key, value);
    }

}
