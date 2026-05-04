package com.tiv.responsibility.chain.multiton.chain;

import com.tiv.responsibility.chain.multiton.factory.MultitonChainFactory;
import com.tiv.responsibility.chain.multiton.handler.ResponsibilityHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MultitonChain2 implements ResponsibilityHandler<String, MultitonChainFactory.DynamicContext, String> {

    @Override
    public String apply(String input, MultitonChainFactory.DynamicContext context) {
        log.info("link MultitonChain2");
        return stop(input, context, "hello responsibility chain!");
    }

}