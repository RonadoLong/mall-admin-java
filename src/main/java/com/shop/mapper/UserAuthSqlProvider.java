package com.shop.mapper;

import com.shop.entity.UserAuth;
import org.apache.ibatis.jdbc.SQL;

public class UserAuthSqlProvider {

    public String insertSelective(UserAuth record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_auth");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentify_type() != null) {
            sql.VALUES("identify_type", "#{identify_type,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentify() != null) {
            sql.VALUES("identify", "#{identify,jdbcType=VARCHAR}");
        }
        
        if (record.getCredential() != null) {
            sql.VALUES("credential", "#{credential,jdbcType=VARCHAR}");
        }
        
        if (record.getTrade_id() != null) {
            sql.VALUES("trade_id", "#{trade_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAuth record) {
        SQL sql = new SQL();
        sql.UPDATE("user_auth");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentify_type() != null) {
            sql.SET("identify_type = #{identify_type,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentify() != null) {
            sql.SET("identify = #{identify,jdbcType=VARCHAR}");
        }
        
        if (record.getCredential() != null) {
            sql.SET("credential = #{credential,jdbcType=VARCHAR}");
        }
        
        if (record.getTrade_id() != null) {
            sql.SET("trade_id = #{trade_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}