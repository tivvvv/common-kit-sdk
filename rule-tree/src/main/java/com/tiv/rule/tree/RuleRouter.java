package com.tiv.rule.tree;

/**
 * 规则路由器接口
 *
 * @param <I> 入参
 * @param <C> 上下文
 * @param <O> 出参
 */
public interface RuleRouter<I, C, O> {

    /**
     * 执行路由
     *
     * @param input
     * @param context
     * @return
     */
    RuleHandler<I, C, O> route(I input, C context);

}
