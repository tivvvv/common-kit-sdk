package com.tiv.responsibility.chain.singleton;

import com.tiv.responsibility.chain.singleton.factory.SingletonChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingletonResponsibilityChainTestApplication.class)
public class SingletonResponsibilityChainTest {

    @Resource
    private SingletonChainFactory singletonChainFactory;

    @Test
    public void test() {
        SingletonResponsibilityChain<String, SingletonChainFactory.DynamicContext, String> chain = singletonChainFactory.getChain();
        String result = chain.apply("input", new SingletonChainFactory.DynamicContext());
        log.info(result);
    }

}
