package com.fetters.lingxi.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author : Fetters
 * @description : Redisson测试类
 * @createDate : 2025/4/7 19:32
 */
@SpringBootTest
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;

    @Test
    public void testRedisson() {
        // list
        RList<Object> rList = redissonClient.getList("test-list");
        rList.add("fetters");
        System.out.println(rList);
        rList.remove(0);

        // map
        RMap<String, Object> map = redissonClient.getMap("test-map");
        map.put("fetters", 10);
        map.get("fetters");
    }

    @Test
    void testWatchDog() {
        RLock lock = redissonClient.getLock("lingxi:precachejob:docache:lock");
        try {
            // 只有一个线程能获取到锁
            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                // 强制睡眠触发看门狗机制
                Thread.sleep(60000);
                System.out.println("getLock: " + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            // 只能释放自己的锁
            if (lock.isHeldByCurrentThread()) {
                System.out.println("unLock: " + Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}

