package com.tiv.rule.tree;

import com.tiv.rule.tree.factory.DefaultRuleFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuleTreeTestApplication.class)
public class RuleTreeTest {

    @Resource
    private DefaultRuleFactory defaultRuleFactory;

    @Test
    public void test() {
        RuleHandler<String, DefaultRuleFactory.DynamicContext, String> ruleHandler = defaultRuleFactory.ruleHandler();
        String res = ruleHandler.handle("tivvvv", new DefaultRuleFactory.DynamicContext());
        log.info(res);
    }

}