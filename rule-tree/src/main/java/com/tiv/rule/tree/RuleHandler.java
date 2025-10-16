package com.tiv.rule.tree;

/**
 * 规则处理器接口
 *
 * @param <I> 入参
 * @param <C> 上下文
 * @param <O> 出参
 */
public interface RuleHandler<I, C, O> {

    /**
     * 默认处理,直接返回null
     */
    RuleHandler<?, ?, ?> DEFAULT = (input, context) -> null;

    /**
     * 执行处理
     *
     * @param input   入参
     * @param context 上下文
     * @return 处理结果
     */
    O handle(I input, C context);

}
