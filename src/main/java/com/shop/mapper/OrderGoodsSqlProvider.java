package com.shop.mapper;

import com.shop.entity.OrderGoods;
import org.apache.ibatis.jdbc.SQL;

public class OrderGoodsSqlProvider {

    public String insertSelective(OrderGoods record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_goods");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_id() != null) {
            sql.VALUES("order_id", "#{order_id,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_id() != null) {
            sql.VALUES("product_id", "#{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getGoods_title() != null) {
            sql.VALUES("goods_title", "#{goods_title,jdbcType=VARCHAR}");
        }
        
        if (record.getGoods_price() != null) {
            sql.VALUES("goods_price", "#{goods_price,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_price() != null) {
            sql.VALUES("total_price", "#{total_price,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_image() != null) {
            sql.VALUES("goods_image", "#{goods_image,jdbcType=VARCHAR}");
        }
        
        if (record.getGoods_count() != null) {
            sql.VALUES("goods_count", "#{goods_count,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_number() != null) {
            sql.VALUES("goods_number", "#{goods_number,jdbcType=VARCHAR}");
        }
        
        if (record.getSku_id() != null) {
            sql.VALUES("sku_id", "#{sku_id,jdbcType=BIGINT}");
        }
        
        if (record.getSku_values() != null) {
            sql.VALUES("sku_values", "#{sku_values,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderGoods record) {
        SQL sql = new SQL();
        sql.UPDATE("order_goods");
        
        if (record.getOrder_id() != null) {
            sql.SET("order_id = #{order_id,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_id() != null) {
            sql.SET("product_id = #{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getGoods_title() != null) {
            sql.SET("goods_title = #{goods_title,jdbcType=VARCHAR}");
        }
        
        if (record.getGoods_price() != null) {
            sql.SET("goods_price = #{goods_price,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_price() != null) {
            sql.SET("total_price = #{total_price,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_image() != null) {
            sql.SET("goods_image = #{goods_image,jdbcType=VARCHAR}");
        }
        
        if (record.getGoods_count() != null) {
            sql.SET("goods_count = #{goods_count,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_number() != null) {
            sql.SET("goods_number = #{goods_number,jdbcType=VARCHAR}");
        }
        
        if (record.getSku_id() != null) {
            sql.SET("sku_id = #{sku_id,jdbcType=BIGINT}");
        }
        
        if (record.getSku_values() != null) {
            sql.SET("sku_values = #{sku_values,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}