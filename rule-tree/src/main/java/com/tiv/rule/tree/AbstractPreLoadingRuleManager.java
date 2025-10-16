package com.tiv.rule.tree;

/**
 * 预加载规则管理器抽象类
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public abstract class AbstractPreLoadingRuleManager<I, C, O> extends AbstractRuleManager<I, C, O> {

    @Override
    public O handle(I input, C context) {
        // 预加载
        load(input, context);
        // 处理业务
        return doHandle(input, context);
    }

    /**
     * 加载数据
     *
     * @param input
     * @param context
     */
    protected abstract void load(I input, C context);

    /**
     * 处理业务
     *
     * @param input
     * @param context
     * @return
     */
    protected abstract O doHandle(I input, C context);

}
