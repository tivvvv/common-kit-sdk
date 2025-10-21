package com.tiv.rule.tree.support;

import java.util.concurrent.TimeUnit;

public interface ThreadPoolProperties {

    int CORE_POOL_SIZE = 10;

    int MAX_POOL_SIZE = 20;

    int KEEP_ALIVE_TIME = 10;

    TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    int BLOCKING_QUEUE_CAPACITY = 100;

}
