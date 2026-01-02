package com.tiv.responsibility.chain.multiton.handler;

import com.tiv.responsibility.chain.multiton.helper.DynamicContext;

/**
 * 责任处理器
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public interface ResponsibilityHandler<I, C extends DynamicContext, O> {

    default O next(I input, C context) {
        context.setProceed(true);
        return null;
    }

    default O stop(I input, C context, O output) {
        context.setProceed(true);
        return null;
    }

    O apply(I input, C context);

}
