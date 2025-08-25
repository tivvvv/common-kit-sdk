package com.tiv.dynamic.config.center.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dynamic.config.center", ignoreInvalidFields = true)
public class DynamicConfigCenterProperties {

    private String application;

    public String getKey(String attribute) {
        return String.format("%s_%s", this.application, attribute);
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

}
