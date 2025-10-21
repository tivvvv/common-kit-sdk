package com.tiv.rule.tree.node;

import com.tiv.rule.tree.RuleHandler;
import com.tiv.rule.tree.factory.DefaultRuleFactory;
import com.tiv.rule.tree.support.AbstractRuleSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class RootNode extends AbstractRuleSupport {

    @Resource
    private SwitchNode switchNode;

    @Override
    protected String doHandle(String input, DefaultRuleFactory.DynamicContext context) {
        log.info("[RootNode] input:{}", input);
        return apply(input, context);
    }

    @Override
    public RuleHandler<String, DefaultRuleFactory.DynamicContext, String> route(String input, DefaultRuleFactory.DynamicContext context) {
        return switchNode;
    }

}
