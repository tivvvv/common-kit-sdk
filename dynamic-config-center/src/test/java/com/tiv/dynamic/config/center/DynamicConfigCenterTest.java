package com.tiv.dynamic.config.center;

import com.tiv.dynamic.config.center.domain.model.Attribute;
import com.tiv.dynamic.config.center.types.annotation.DynamicConfigCenterValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RTopic;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DynamicConfigCenterTest {

    @DynamicConfigCenterValue(value = "testField:200")
    private String testField;

    @Resource
    private RTopic dynamicConfigCenterRedisTopic;

    @Test
    public void test() throws InterruptedException {
        System.out.println("testField发布前值为:" + testField);
        dynamicConfigCenterRedisTopic.publish(new Attribute("testField", "150"));
        CountDownLatch latch = new CountDownLatch(1);
        latch.await(5, TimeUnit.SECONDS);
        System.out.println("testField发布后值为:" + testField);
    }

}
