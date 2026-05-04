package com.tiv.responsibility.chain.multiton.helper;

import com.tiv.responsibility.chain.multiton.BusinessResponsibilityChain;
import com.tiv.responsibility.chain.multiton.handler.ResponsibilityHandler;
import lombok.Getter;

/**
 * 责任链装配器
 */
@Getter
public class ResponsibilityChainAssembler<I, C extends DynamicContext, O> {

    private final BusinessResponsibilityChain<I, C, O> responsibilityChain;

    @SafeVarargs
    public ResponsibilityChainAssembler(String chainName, ResponsibilityHandler<I, C, O>... handlers) {
        responsibilityChain = new BusinessResponsibilityChain<>(chainName);
        for (ResponsibilityHandler<I, C, O> handler : handlers) {
            responsibilityChain.add(handler);
        }
    }

}