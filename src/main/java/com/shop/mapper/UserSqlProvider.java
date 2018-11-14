package com.shop.mapper;

import com.shop.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            sql.VALUES("real_name", "#{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=CHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getHometown() != null) {
            sql.VALUES("hometown", "#{hometown,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLogin_Time() != null) {
            sql.VALUES("login_Time", "#{login_Time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIs_recommend() != null) {
            sql.VALUES("is_recommend", "#{is_recommend,jdbcType=CHAR}");
        }
        
        if (record.getRecommend_code() != null) {
            sql.VALUES("recommend_code", "#{recommend_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.VALUES("commission", "#{commission,jdbcType=INTEGER}");
        }
        
        if (record.getBirth() != null) {
            sql.VALUES("birth", "#{birth,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            sql.SET("real_name = #{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=CHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getHometown() != null) {
            sql.SET("hometown = #{hometown,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLogin_Time() != null) {
            sql.SET("login_Time = #{login_Time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIs_recommend() != null) {
            sql.SET("is_recommend = #{is_recommend,jdbcType=CHAR}");
        }
        
        if (record.getRecommend_code() != null) {
            sql.SET("recommend_code = #{recommend_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getIntegral() != null) {
            sql.SET("integral = #{integral,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.SET("commission = #{commission,jdbcType=INTEGER}");
        }
        
        if (record.getBirth() != null) {
            sql.SET("birth = #{birth,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("user_id = #{user_id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}