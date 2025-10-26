package com.tiv.responsibility.chain.singleton.factory;

import com.tiv.responsibility.chain.singleton.SingletonResponsibilityChain;
import com.tiv.responsibility.chain.singleton.chain.SingletonChain1;
import com.tiv.responsibility.chain.singleton.chain.SingletonChain2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SingletonChainFactory {

    @Resource
    private SingletonChain1 chain1;

    @Resource
    private SingletonChain2 chain2;

    public SingletonResponsibilityChain<String, DynamicContext, String> getChain() {
        chain1.assemble(chain2);
        return chain1;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private int level;

    }

}
