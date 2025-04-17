package com.fetters.lingxi.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Fetters
 * @description : 用户退出队伍请求体
 * @createDate : 2025/4/11 14:19
 */
@Data
public class TeamQuitRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -8245684775404385236L;

    /**
     * 队伍id
     */
    private Long teamId;
}

