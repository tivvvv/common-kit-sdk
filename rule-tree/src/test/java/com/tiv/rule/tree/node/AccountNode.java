package com.tiv.rule.tree.node;

import com.tiv.rule.tree.RuleHandler;
import com.tiv.rule.tree.factory.DefaultRuleFactory;
import com.tiv.rule.tree.support.AbstractRuleSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Component
public class AccountNode extends AbstractRuleSupport {

    @Resource
    private MemberLevel1Node memberLevel1Node;

    @Resource
    private MemberLevel2Node memberLevel2Node;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    private static final String ACCOUNT_STATUS = "accountStatus";

    private static final String ACCOUNT_BALANCE = "accountBalance";

    @Override
    protected void load(String input, DefaultRuleFactory.DynamicContext context) {
        CompletableFuture<String> accountStatus = CompletableFuture.supplyAsync(() -> {
            log.info("[AccountNode] 异步查询账户状态: 可用|冻结");
            return new Random().nextBoolean() ? "账户可用" : "账户冻结";
        }, threadPoolExecutor);

        CompletableFuture<String> accountBalance = CompletableFuture.supplyAsync(() -> {
            log.info("[AccountNode] 异步查询账户余额: 有余额|无余额");
            return new Random().nextBoolean() ? "有余额" : "无余额";
        }, threadPoolExecutor);

        CompletableFuture.allOf(accountStatus, accountBalance).thenRun(() -> {
            context.setValue(ACCOUNT_STATUS, accountStatus.join());
            context.setValue(ACCOUNT_BALANCE, accountBalance.join());
        }).join();
    }

    @Override
    protected String doHandle(String input, DefaultRuleFactory.DynamicContext context) {
        log.info("[AccountNode] input:{}", input);

        int level = new Random().nextInt(2);
        log.info("[AccountNode] 模拟查询用户级别 level:{}", level);
        context.setLevel(level);
        return apply(input, context);
    }

    @Override
    public RuleHandler<String, DefaultRuleFactory.DynamicContext, String> route(String input, DefaultRuleFactory.DynamicContext context) {
        String accountStatus = context.getValue(ACCOUNT_STATUS);
        String accountBalance = context.getValue(ACCOUNT_BALANCE);
        int level = context.getLevel();

        if ("账户冻结".equals(accountStatus)) {
            return memberLevel1Node;
        }

        if ("无余额".equals(accountBalance)) {
            return memberLevel1Node;
        }

        if (level == 1) {
            return memberLevel1Node;
        }

        return memberLevel2Node;
    }

}
