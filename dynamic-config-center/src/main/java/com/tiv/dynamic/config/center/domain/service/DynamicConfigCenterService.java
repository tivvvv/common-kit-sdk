package com.tiv.dynamic.config.center.domain.service;

import com.tiv.dynamic.config.center.domain.model.Attribute;

/**
 * 动态配置中心服务
 */
public interface DynamicConfigCenterService {

    /**
     * 初始化动态配置的bean对象
     *
     * @param bean
     * @return
     */
    Object initializeDynamicConfigBean(Object bean);

    /**
     * 调整属性值
     *
     * @param attribute
     */
    void adjustAttribute(Attribute attribute);

}
