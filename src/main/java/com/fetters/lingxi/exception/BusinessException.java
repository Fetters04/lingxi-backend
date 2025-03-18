package com.fetters.lingxi.exception;

import com.fetters.lingxi.common.ErrorCode;

import java.io.Serial;

/**
 * 自定义异常类
 *
 * @author Fetters
 */
public class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5683084540555071257L;

    private final int code;

    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
