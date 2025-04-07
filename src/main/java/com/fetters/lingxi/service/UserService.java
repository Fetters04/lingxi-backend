package com.fetters.lingxi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @return 脱敏后的用户信息
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
     * @param tagNameList 搜索标签
     * @return 包含所有标签的用户列表
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int updateUser(User user, HttpServletRequest request);

    /**
     * 获取登录用户
     *
     * @param request
     * @return 登录用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 当前用户是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 从缓存中读取分页用户信息
     *
     * @param pageNum  当前页码
     * @param pageSize 页数
     * @param redisKey 当前用户对应的 key
     * @return 用户分页数据
     */
    Page<User> getUserPage(long pageNum, long pageSize, String redisKey);
}
