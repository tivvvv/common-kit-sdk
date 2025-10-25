package com.tiv.responsibility.chain.singleton;

/**
 * 责任链装配器接口
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public interface SingletonResponsibilityChainAssembler<I, C, O> {

    SingletonResponsibilityChain<I, C, O> next();

    SingletonResponsibilityChain<I, C, O> assemble(SingletonResponsibilityChain<I, C, O> next);

}
