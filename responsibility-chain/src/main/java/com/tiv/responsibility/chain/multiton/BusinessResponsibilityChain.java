package com.tiv.responsibility.chain.multiton;

import com.tiv.responsibility.chain.multiton.handler.ResponsibilityHandler;
import com.tiv.responsibility.chain.multiton.helper.DynamicContext;

/**
 * 业务责任链
 *
 * @param <I>
 * @param <C>
 * @param <O>
 */
public class BusinessResponsibilityChain<I, C extends DynamicContext, O> extends LinkedResponsibilityChain<ResponsibilityHandler<I, C, O>> implements ResponsibilityHandler<I, C, O> {

    public BusinessResponsibilityChain(String name) {
        super(name);
    }

    @Override
    public O apply(I input, C context) {
        Node<ResponsibilityHandler<I, C, O>> cur = this.first;
        while (cur != null) {
            ResponsibilityHandler<I, C, O> val = cur.val;
            O output = val.apply(input, context);
            if (!context.isProceed()) {
                return output;
            }
            cur = cur.next;
        }
        return null;
    }

}
