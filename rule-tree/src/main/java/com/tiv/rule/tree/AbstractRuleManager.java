package com.tiv.rule.tree;

/**
 * 规则管理器抽象类
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public abstract class AbstractRuleManager<I, C, O> implements RuleHandler<I, C, O>, RuleRouter<I, C, O> {

    protected RuleHandler<I, C, O> DEFAULT_RULE_HANDLER = (RuleHandler<I, C, O>) RuleHandler.DEFAULT;

    /**
     * 应用
     *
     * @param input
     * @param context
     * @return
     */
    public O apply(I input, C context) {
        RuleHandler<I, C, O> ruleHandler = route(input, context);
        if (ruleHandler != null) {
            return ruleHandler.handle(input, context);
        }
        return DEFAULT_RULE_HANDLER.handle(input, context);
    }

}
