package com.tiv.responsibility.chain.singleton.chain;

import com.tiv.responsibility.chain.singleton.AbstractSingletonResponsibilityChain;
import com.tiv.responsibility.chain.singleton.factory.SingletonChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SingletonChain1 extends AbstractSingletonResponsibilityChain<String, SingletonChainFactory.DynamicContext, String> {

    @Override
    public String apply(String input, SingletonChainFactory.DynamicContext context) {
        log.info("单例责任链 Chain1");
        return next(input, context);
    }

}
