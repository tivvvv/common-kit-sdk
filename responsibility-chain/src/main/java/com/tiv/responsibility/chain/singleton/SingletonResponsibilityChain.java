package com.tiv.responsibility.chain.singleton;

/**
 * 责任链接口
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public interface SingletonResponsibilityChain<I, C, O> extends SingletonResponsibilityChainAssembler<I, C, O> {

    O apply(I input, C context);

}
