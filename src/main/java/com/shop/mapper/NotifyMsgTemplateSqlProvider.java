package com.shop.mapper;

import com.shop.entity.NotifyMsgTemplate;
import org.apache.ibatis.jdbc.SQL;

public class NotifyMsgTemplateSqlProvider {

    public String insertSelective(NotifyMsgTemplate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("notify_msg_template");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("createUser", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("createdTime", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.VALUES("updateUser", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatedTime() != null) {
            sql.VALUES("updatedTime", "#{updatedTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NotifyMsgTemplate record) {
        SQL sql = new SQL();
        sql.UPDATE("notify_msg_template");
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("createUser = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("createdTime = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("updateUser = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatedTime() != null) {
            sql.SET("updatedTime = #{updatedTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}