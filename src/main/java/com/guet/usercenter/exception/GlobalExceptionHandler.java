package com.guet.usercenter.exception;

import com.guet.usercenter.common.BaseResponse;
import com.guet.usercenter.common.ErrorCode;
import com.guet.usercenter.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.transform.Result;

/**
 * 全局异常处理器
 *
 * @author Fetters
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 捕获 BusinessException 异常
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("BusinessException: " + e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException: ", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), "");
    }
}
