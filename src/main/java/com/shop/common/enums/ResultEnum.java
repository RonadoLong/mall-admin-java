package com.shop.common.enums;

/**
 * 返回枚举
 */
public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    FAIL(1001,"操作失败"),
    LOGINSUCCESS(1000, "登录成功"),
    LOGINFAIL(1001, "登录失败"),
    PARAMS_ERROR(1002, "参数有误"),
    USER_NOTEXIST(1004, "用户不存在"),
    USER_EXIST(1005, "用户已存在"),
    CODE_NOTEXIST(1006, "验证码错误"),
    ADDRESS_NOTEXIST(1007, "地区不存在"),
    PHONE_ERROR(1008, "手机号码有误"),
    BING_ERROR(1009, "账号已绑定"),
    NOT_ANY_MORE(1010, "没有更多数据"),
    TOKEN_ERROR(1010, "没有权限操作"),
    ;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
