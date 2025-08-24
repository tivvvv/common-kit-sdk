package com.tiv.dynamic.config.center.domain.service.impl;

import com.tiv.dynamic.config.center.domain.model.Attribute;
import com.tiv.dynamic.config.center.domain.service.DynamicConfigCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态配置中心服务实现
 */
public class DynamicConfigCenterServiceImpl implements DynamicConfigCenterService {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterService.class);

    @Override
    public Object initializeDynamicConfigBean(Object bean) {
        return null;
    }

    @Override
    public void adjustAttribute(Attribute attribute) {

    }

}
