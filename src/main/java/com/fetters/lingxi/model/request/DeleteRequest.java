package com.fetters.lingxi.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Fetters
 * @description : 通用删除请求
 * @createDate : 2025/4/14 21:48
 */
@Data
public class DeleteRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -4362288041972876242L;

    private long id;
}

