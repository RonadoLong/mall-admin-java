package com.shop.common.exception;


import com.shop.common.enums.ResultEnum;

public class BaseException extends RuntimeException {

    int code;

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
