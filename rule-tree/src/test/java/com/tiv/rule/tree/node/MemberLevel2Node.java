package com.tiv.rule.tree.node;

import com.alibaba.fastjson.JSON;
import com.tiv.rule.tree.RuleHandler;
import com.tiv.rule.tree.factory.DefaultRuleFactory;
import com.tiv.rule.tree.support.AbstractRuleSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberLevel2Node extends AbstractRuleSupport {

    @Override
    protected String doHandle(String input, DefaultRuleFactory.DynamicContext context) {
        log.info("[MemberLevel2Node] input:{}", input);
        return "level2: " + JSON.toJSONString(context);
    }

    @Override
    public RuleHandler<String, DefaultRuleFactory.DynamicContext, String> route(String input, DefaultRuleFactory.DynamicContext context) {
        return DEFAULT_RULE_HANDLER;
    }

}
