package com.shop.mapper;

import com.shop.entity.ServiceCategory;
import org.apache.ibatis.jdbc.SQL;

public class ServiceCategorySqlProvider {

    public String insertSelective(ServiceCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("service_category");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_name() != null) {
            sql.VALUES("en_name", "#{en_name,jdbcType=VARCHAR}");
        }
        
        if (record.getImageurl() != null) {
            sql.VALUES("imageurl", "#{imageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getSettings() != null) {
            sql.VALUES("settings", "#{settings,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ServiceCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("service_category");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_name() != null) {
            sql.SET("en_name = #{en_name,jdbcType=VARCHAR}");
        }
        
        if (record.getImageurl() != null) {
            sql.SET("imageurl = #{imageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getSettings() != null) {
            sql.SET("settings = #{settings,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}