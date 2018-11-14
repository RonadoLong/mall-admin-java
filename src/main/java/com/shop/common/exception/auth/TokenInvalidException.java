package com.shop.common.exception.auth;


import com.shop.common.enums.ResultEnum;
import com.shop.common.exception.BaseException;

public class TokenInvalidException extends BaseException {

    public TokenInvalidException(String message, int code) {
        super(message, code);
    }

    public TokenInvalidException(String message) {
        super(message);
    }

    public TokenInvalidException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
