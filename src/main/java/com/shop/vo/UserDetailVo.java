package com.shop.vo;

import lombok.Data;

@Data
public class UserDetailVo {


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别 0为保密 1女 2男
     */
    private Byte sex;

    /**
     * 生日
     */
    private String birth;

    /**
     * 家乡
     */
    private String hometown;

    /**
     * 现居
     */
    private String address;

    /**
     * 个性签名
     */
    private String remark;

    /**
     * 微信的openId
     */
    private String wechatId;

    /**
     * 话题发布量
     */
    private int postCount;

    /**
     * 话题点赞量
     */
    private int postLikedCount;

    /**
     * 话题评论数
     */
    private int postCommentCount;


    /**
     * 话题评论点赞数
     */
    private int postCommentLikedCount;

    /**
     * 用户阅读文章数
     */
    private int infoReadCount;

    /**
     * 资讯评论数
     */
    private int infoCommentCount;

    /**
     * 活动参与数
     */
    private int activityAttendCount;

    /**
     * 活动评论数
     */
    private int activityCommentCount;

    /**
     * 状态
     */
    private byte status;

    /**
     * 头像
     */
    private String avatar;
}
