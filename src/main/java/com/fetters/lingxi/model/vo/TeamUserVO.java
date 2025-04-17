package com.fetters.lingxi.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : Fetters
 * @description : 队伍和用户信息封装类
 * @createDate : 2025/4/10 16:59
 */
@Data
public class TeamUserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3874334640744504718L;
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 入队用户列表
     */
    private UserVO createUser;

    /**
     * 已加入队伍的人数
     */
    private Integer hasJoinNum;

    /**
     * 是否已加入队伍
     */
    private boolean hasJoin = false;
}

