package com.fetters.lingxi.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Fetters
 * @description : 通用分页请求参数
 * @createDate : 2025/4/10 10:04
 */
@Data
public class PageRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 8305130615931691556L;

    /**
     * 当前页数
     */
    protected int pageNum = 1;

    /**
     * 页面大小
     */
    protected int pageSize = 10;
}

