package com.shop.common.exception;


import com.shop.common.enums.ResultEnum;

public class NotMoreException extends BaseException {

    public NotMoreException(String message, int code) {
        super(message, code);
    }

    public NotMoreException(String message) {
        super(message);
    }

    public NotMoreException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
