package com.fetters.lingxi.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Fetters
 * @description : 用户加入队伍请求体
 * @createDate : 2025/4/11 10:35
 */
@Data
public class TeamJoinRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 876471081858226108L;

    /**
     * 队伍id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}

