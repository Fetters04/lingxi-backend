package com.fetters.lingxi.service;

import com.fetters.lingxi.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("fetters");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        user.setGender(0);
        user.setPassword("123456");
        user.setPhone("321");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());

        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "xiebo";
        String password = "";
        String checkPassword = "12345678";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "x";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiebo";
        password = "123456";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xie bo";
        password = "12345678";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiebo";
        checkPassword = "123456";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "123";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiebo";
        result = userService.userRegister(userAccount, password, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

    }

    @Test
    public void testSearchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java", "Python");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        System.out.println(userList);
        Assertions.assertNotNull(userList);
    }
}