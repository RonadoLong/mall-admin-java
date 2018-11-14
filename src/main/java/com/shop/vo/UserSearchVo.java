package com.shop.vo;

import lombok.Data;

/**
 * id : 用户Id
 * key: 用户昵称
 * pageNum: 页数
 * pageSize: 分页大小
 */
@Data
public class UserSearchVo {

    private String userId;

    private String nickname;

    private String startTime;

    private String endTime;

    private String lastLoginTime;
}
