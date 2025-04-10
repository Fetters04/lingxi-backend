package com.fetters.lingxi.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author Fetters
 */
@Data
public class UserRegisterRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -4306646630104397834L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
