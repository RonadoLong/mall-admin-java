package com.shop.common.exception;


import com.shop.common.enums.ResultEnum;

public class NotFoundException extends BaseException {

    public NotFoundException(String message, int code) {
        super(message, code);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
