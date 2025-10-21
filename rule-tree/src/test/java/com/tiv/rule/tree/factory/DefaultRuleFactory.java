package com.tiv.rule.tree.factory;

import com.tiv.rule.tree.RuleHandler;
import com.tiv.rule.tree.node.RootNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultRuleFactory {

    private final RootNode rootNode;

    public DefaultRuleFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public RuleHandler<String, DynamicContext, String> ruleHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private int level;

        private Map<String, Object> contextMap = new HashMap<>();

        public <T> void setValue(String key, T value) {
            contextMap.put(key, value);
        }

        public <T> T getValue(String key) {
            return (T) contextMap.get(key);
        }

    }

}
