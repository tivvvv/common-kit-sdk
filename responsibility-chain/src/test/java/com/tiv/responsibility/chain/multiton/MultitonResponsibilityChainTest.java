package com.tiv.responsibility.chain.multiton;

import com.tiv.responsibility.chain.multiton.factory.MultitonChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultitonResponsibilityChainTestApplication.class)
public class MultitonResponsibilityChainTest {

    @Resource(name = "demo1")
    private BusinessResponsibilityChain<String, MultitonChainFactory.DynamicContext, String> responsibilityChain1;

    @Resource(name = "demo2")
    private BusinessResponsibilityChain<String, MultitonChainFactory.DynamicContext, String> responsibilityChain2;

    @Test
    public void testDemo1() {
        String res = responsibilityChain1.apply("1", new MultitonChainFactory.DynamicContext());
        log.info("demo1 res:{}", res);
    }

    @Test
    public void testDemo2() {
        String res = responsibilityChain2.apply("2", new MultitonChainFactory.DynamicContext());
        log.info("demo2 res:{}", res);
    }

}