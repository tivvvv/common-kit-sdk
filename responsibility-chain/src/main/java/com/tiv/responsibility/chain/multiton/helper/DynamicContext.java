package com.tiv.responsibility.chain.multiton.helper;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 责任链动态上下文
 */
public class DynamicContext {

    @Setter
    @Getter
    private boolean proceed;

    private Map<String, Object> dataMap = new HashMap<>();

    public DynamicContext() {
        this.proceed = true;
    }

    public <T> T getValue(String key) {
        return (T) dataMap.get(key);
    }

    public <T> void setValue(String key, T value) {
        dataMap.put(key, value);
    }

}
