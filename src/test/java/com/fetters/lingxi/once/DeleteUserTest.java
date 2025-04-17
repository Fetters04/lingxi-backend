package com.fetters.lingxi.once;

import com.fetters.lingxi.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Fetters
 * @description : 删除用户
 * @createDate : 2025/4/16 11:21
 */
@SpringBootTest
public class DeleteUserTest {
    @Resource
    public UserMapper userMapper;

    @Test
    public void deleteUser() {
        List<Long> userIdList = new ArrayList<>();
        for (int i = 100001; i <= 1000002; i++) {
            userIdList.add((long) i);
        }
        userMapper.deleteByIds(userIdList);
    }
}

