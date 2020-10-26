package com.love.exception;


import org.springframework.http.HttpStatus;

/**
 * @ClassName BadRequestException
 * @description 统一异常处理
 * @author ocean
 * @createDate 2020/10/26
 * @version 1.0.0
 */
public class BadRequestException extends RuntimeException {
    private Integer status = HttpStatus.BAD_REQUEST.value();

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg) {
        super(msg);
        this.status = status.value();
    }
}
