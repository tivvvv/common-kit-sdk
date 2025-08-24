package com.tiv.dynamic.config.center.types.common;

public class Constants {

    public static final String DYNAMIC_CONFIG_CENTER_REDIS_TOPIC_PREFIX = "DYNAMIC_CONFIG_CENTER_REDIS_TOPIC_";

    public static String getTopic(String application) {
        return DYNAMIC_CONFIG_CENTER_REDIS_TOPIC_PREFIX + application;
    }

}
