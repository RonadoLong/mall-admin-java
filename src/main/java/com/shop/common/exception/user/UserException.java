package com.shop.common.exception.user;


import com.shop.common.enums.ResultEnum;
import com.shop.common.exception.BaseException;

/**
 * 处理用户异常
 */
public class UserException extends BaseException {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserException(String message, int code) {
        super(message);
        this.code = code;
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
