package com.fetters.lingxi.service;

import java.util.Date;

import com.fetters.lingxi.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author : Fetters
 * @description : Redis测试类
 * @createDate : 2025/4/5 10:23
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        ListOperations listOperations = redisTemplate.opsForList();

        // 增
        valueOperations.set("fettersString", "fish");
        valueOperations.set("fettersInteger", 1);
        valueOperations.set("fettersDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yupi");
        valueOperations.set("fettersUser", user);

        // 查
        Object obj = valueOperations.get("fettersString");
        Assertions.assertEquals("fish", obj);
        obj = valueOperations.get("fettersInteger");
        Assertions.assertEquals(1, (Integer) obj);
        obj = valueOperations.get("fettersDouble");
        Assertions.assertEquals(2.0, (Double) obj);
        obj = valueOperations.get("fettersUser");
        System.out.println(obj);
    }
}

