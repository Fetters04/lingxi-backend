package com.fetters.lingxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fetters.lingxi.model.domain.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * @author Fetters
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 确认密码
     * @return 返回注册成功后的用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param user
     * @return
     */
    User getSafetyUser(User user);

    /**
     * 用户注销
     *
     * @param request
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList 用户拥有的标签
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);
}
