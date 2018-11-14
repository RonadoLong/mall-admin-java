package com.shop.common.exception.auth;


import com.shop.common.enums.ResultEnum;
import com.shop.common.exception.BaseException;

public class AuthException extends BaseException {

    public AuthException(String message, int code) {
        super(message, code);
    }

    public AuthException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
