package com.fetters.lingxi.once;

import java.util.Date;

import com.fetters.lingxi.mapper.UserMapper;
import com.fetters.lingxi.model.domain.User;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author : Fetters
 * @description : 批量导入用户数据
 * @createDate : 2025/4/3 11:32
 */
@Component
public class InsertUsers {
    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
    // @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fetters");
            user.setAvatarUrl("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            user.setGender(0);
            user.setPassword("8d8056d29f13015ab9c767e69bad1ae5");
            user.setProfile("我是用户fetters");
            user.setPhone("123456789");
            user.setEmail("123456@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("111");
            user.setTags("[]");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        new InsertUsers().doInsertUsers();
    }
}

