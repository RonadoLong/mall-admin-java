package com.shop.mapper;

import com.shop.entity.ServicePaymentSetting;
import org.apache.ibatis.jdbc.SQL;

public class ServicePaymentSettingSqlProvider {

    public String insertSelective(ServicePaymentSetting record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("service_payment_setting");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_name() != null) {
            sql.VALUES("en_name", "#{en_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=INTEGER}");
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

    public String updateByPrimaryKeySelective(ServicePaymentSetting record) {
        SQL sql = new SQL();
        sql.UPDATE("service_payment_setting");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_name() != null) {
            sql.SET("en_name = #{en_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=INTEGER}");
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
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}