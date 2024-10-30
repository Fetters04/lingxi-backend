package com.guet.usercenter.constant;

import com.guet.usercenter.service.UserService;

/**
 * 用户常量
 *
 * @author Fetters
 */
public interface UserConstant {
    /**
     * 用户登录态键
     */
    String USER_LOGIN_STATE = "userLoginState";


    // ----权限----
    /**
     * 默认
     */
    int DEFAULT_ROLE = 0;
    /**
     * 管理员
     */
    int ADMIN_ROLE = 1;
}
