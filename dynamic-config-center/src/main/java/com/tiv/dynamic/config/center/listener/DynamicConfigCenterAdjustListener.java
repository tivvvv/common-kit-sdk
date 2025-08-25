package com.tiv.dynamic.config.center.listener;

import com.tiv.dynamic.config.center.domain.model.Attribute;
import com.tiv.dynamic.config.center.domain.service.DynamicConfigCenterService;
import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicConfigCenterAdjustListener implements MessageListener<Attribute> {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterAdjustListener.class);

    private final DynamicConfigCenterService dynamicConfigCenterService;

    public DynamicConfigCenterAdjustListener(DynamicConfigCenterService dynamicConfigCenterService) {
        this.dynamicConfigCenterService = dynamicConfigCenterService;
    }

    @Override
    public void onMessage(CharSequence channel, Attribute attribute) {
        log.info("动态配置中心 监听到配置变化: {}", attribute);
        try {
            dynamicConfigCenterService.adjustAttribute(attribute);
        } catch (Exception e) {
            log.error("动态配置中心 调整属性值失败: {}", attribute, e);
        }
    }

}
