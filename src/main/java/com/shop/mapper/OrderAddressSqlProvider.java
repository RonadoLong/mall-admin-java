package com.shop.mapper;

import com.shop.entity.OrderAddress;
import org.apache.ibatis.jdbc.SQL;

public class OrderAddressSqlProvider {

    public String insertSelective(OrderAddress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_address");
        
        if (record.getOrderId() != null) {
            sql.VALUES("orderId", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            sql.VALUES("receiverName", "#{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            sql.VALUES("receiverPhone", "#{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            sql.VALUES("receiverMobile", "#{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverState() != null) {
            sql.VALUES("receiverState", "#{receiverState,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            sql.VALUES("receiverCity", "#{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDistrict() != null) {
            sql.VALUES("receiverDistrict", "#{receiverDistrict,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverAddress() != null) {
            sql.VALUES("receiverAddress", "#{receiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverZip() != null) {
            sql.VALUES("receiverZip", "#{receiverZip,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderAddress record) {
        SQL sql = new SQL();
        sql.UPDATE("order_address");
        
        if (record.getReceiverName() != null) {
            sql.SET("receiverName = #{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            sql.SET("receiverPhone = #{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            sql.SET("receiverMobile = #{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverState() != null) {
            sql.SET("receiverState = #{receiverState,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            sql.SET("receiverCity = #{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDistrict() != null) {
            sql.SET("receiverDistrict = #{receiverDistrict,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverAddress() != null) {
            sql.SET("receiverAddress = #{receiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverZip() != null) {
            sql.SET("receiverZip = #{receiverZip,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("orderId = #{orderId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}