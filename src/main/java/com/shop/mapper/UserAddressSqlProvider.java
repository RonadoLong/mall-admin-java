package com.shop.mapper;

import com.shop.entity.UserAddress;
import org.apache.ibatis.jdbc.SQL;

public class UserAddressSqlProvider {

    public String insertSelective(UserAddress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_address");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_name() != null) {
            sql.VALUES("contact_name", "#{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=VARCHAR}");
        }
        
        if (record.getPostal_code() != null) {
            sql.VALUES("postal_code", "#{postal_code,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_at() != null) {
            sql.VALUES("create_at", "#{create_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_at() != null) {
            sql.VALUES("update_at", "#{update_at,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAddress record) {
        SQL sql = new SQL();
        sql.UPDATE("user_address");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_name() != null) {
            sql.SET("contact_name = #{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=VARCHAR}");
        }
        
        if (record.getPostal_code() != null) {
            sql.SET("postal_code = #{postal_code,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_at() != null) {
            sql.SET("create_at = #{create_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_at() != null) {
            sql.SET("update_at = #{update_at,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}