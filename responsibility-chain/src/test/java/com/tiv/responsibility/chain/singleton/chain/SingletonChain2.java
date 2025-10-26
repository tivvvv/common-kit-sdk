package com.tiv.responsibility.chain.singleton.chain;

import com.tiv.responsibility.chain.singleton.AbstractSingletonResponsibilityChain;
import com.tiv.responsibility.chain.singleton.factory.SingletonChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SingletonChain2 extends AbstractSingletonResponsibilityChain<String, SingletonChainFactory.DynamicContext, String> {

    @Override
    public String apply(String input, SingletonChainFactory.DynamicContext context) {
        log.info("单例责任链 Chain2");
        return "单例责任链 Chain2";
    }

}
