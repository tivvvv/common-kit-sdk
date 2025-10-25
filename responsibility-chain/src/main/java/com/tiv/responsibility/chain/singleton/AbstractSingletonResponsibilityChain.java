package com.tiv.responsibility.chain.singleton;

/**
 * 责任链抽象类
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public abstract class AbstractSingletonResponsibilityChain<I, C, O> implements SingletonResponsibilityChain<I, C, O> {

    private SingletonResponsibilityChain<I, C, O> next;

    protected O next(I input, C context) {
        return next.apply(input, context);
    }

    @Override
    public SingletonResponsibilityChain<I, C, O> next() {
        return this.next;
    }

    @Override
    public SingletonResponsibilityChain<I, C, O> assemble(SingletonResponsibilityChain<I, C, O> next) {
        this.next = next;
        return this.next;
    }

}
