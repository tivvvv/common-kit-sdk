package com.tiv.dynamic.config.center.domain.service;

import com.tiv.dynamic.config.center.domain.model.Attribute;

/**
 * 动态配置中心服务
 */
public interface DynamicConfigCenterService {

    Object initializeDynamicConfigBean(Object bean);

    void adjustAttribute(Attribute attribute);

}
