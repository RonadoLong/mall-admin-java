package com.shop.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserListVo{

    /**
     * 用户Id
     */
    private String id;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    private String realName;

    private String mobile;

    /**
     * 性别 0为保密 1女 2男
     */
    private Byte sex;

    /**
     * 现居
     */
    private String address;

    /**
     * 家乡
     */
    private String hometown;

    /**
     * 内容发布量
     */
    private int contentCount;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户状态
     */
    private byte status;
}
