package com.shop.mapper;

import com.shop.entity.GoodsProperties;
import org.apache.ibatis.jdbc.SQL;

public class GoodsPropertiesSqlProvider {

    public String insertSelective(GoodsProperties record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods_properties");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getGoodsId() != null) {
            sql.VALUES("goodsId", "#{goodsId,jdbcType=BIGINT}");
        }
        
        if (record.getPropertyName() != null) {
            sql.VALUES("propertyName", "#{propertyName,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberPrice() != null) {
            sql.VALUES("memberPrice", "#{memberPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getLowPrice() != null) {
            sql.VALUES("lowPrice", "#{lowPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getActivityPrice() != null) {
            sql.VALUES("activityPrice", "#{activityPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.VALUES("discountPrice", "#{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPreSalePrice() != null) {
            sql.VALUES("preSalePrice", "#{preSalePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getActivityEnable() != null) {
            sql.VALUES("activityEnable", "#{activityEnable,jdbcType=VARCHAR}");
        }
        
        if (record.getIsActive() != null) {
            sql.VALUES("isActive", "#{isActive,jdbcType=VARCHAR}");
        }
        
        if (record.getSoldNumber() != null) {
            sql.VALUES("soldNumber", "#{soldNumber,jdbcType=INTEGER}");
        }
        
        if (record.getStockNumber() != null) {
            sql.VALUES("stockNumber", "#{stockNumber,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.VALUES("commission", "#{commission,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesStatus() != null) {
            sql.VALUES("shelvesStatus", "#{shelvesStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsProperties record) {
        SQL sql = new SQL();
        sql.UPDATE("goods_properties");
        
        if (record.getGoodsId() != null) {
            sql.SET("goodsId = #{goodsId,jdbcType=BIGINT}");
        }
        
        if (record.getPropertyName() != null) {
            sql.SET("propertyName = #{propertyName,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberPrice() != null) {
            sql.SET("memberPrice = #{memberPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getLowPrice() != null) {
            sql.SET("lowPrice = #{lowPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getActivityPrice() != null) {
            sql.SET("activityPrice = #{activityPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discountPrice = #{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPreSalePrice() != null) {
            sql.SET("preSalePrice = #{preSalePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getActivityEnable() != null) {
            sql.SET("activityEnable = #{activityEnable,jdbcType=VARCHAR}");
        }
        
        if (record.getIsActive() != null) {
            sql.SET("isActive = #{isActive,jdbcType=VARCHAR}");
        }
        
        if (record.getSoldNumber() != null) {
            sql.SET("soldNumber = #{soldNumber,jdbcType=INTEGER}");
        }
        
        if (record.getStockNumber() != null) {
            sql.SET("stockNumber = #{stockNumber,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.SET("commission = #{commission,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegral() != null) {
            sql.SET("integral = #{integral,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesStatus() != null) {
            sql.SET("shelvesStatus = #{shelvesStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}