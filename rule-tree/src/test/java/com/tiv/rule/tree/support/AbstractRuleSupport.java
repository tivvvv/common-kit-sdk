package com.tiv.rule.tree.support;

import com.tiv.rule.tree.AbstractPreLoadingRuleManager;
import com.tiv.rule.tree.factory.DefaultRuleFactory;

public abstract class AbstractRuleSupport extends AbstractPreLoadingRuleManager<String, DefaultRuleFactory.DynamicContext, String> {

    /**
     * 1. load方法在需要的节点重写, 不需要的节点无需处理
     * 2. 加载大量数据时可以用多线程异步操作
     */
    @Override
    protected void load(String input, DefaultRuleFactory.DynamicContext context) {

    }

}
