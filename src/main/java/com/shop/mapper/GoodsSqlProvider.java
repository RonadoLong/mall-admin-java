package com.shop.mapper;

import com.shop.entity.Goods;
import org.apache.ibatis.jdbc.SQL;

public class GoodsSqlProvider {

    public String insertSelective(Goods record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods");
        
        if (record.getGoods_id() != null) {
            sql.VALUES("goods_id", "#{goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getMerchant_id() != null) {
            sql.VALUES("merchant_id", "#{merchant_id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_id() != null) {
            sql.VALUES("category_id", "#{category_id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.VALUES("en_title", "#{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getSell_point() != null) {
            sql.VALUES("sell_point", "#{sell_point,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_sell_point() != null) {
            sql.VALUES("en_sell_point", "#{en_sell_point,jdbcType=VARCHAR}");
        }
        
        if (record.getTag_id() != null) {
            sql.VALUES("tag_id", "#{tag_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_images() != null) {
            sql.VALUES("goods_images", "#{goods_images,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_activity() != null) {
            sql.VALUES("has_activity", "#{has_activity,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_type() != null) {
            sql.VALUES("goods_type", "#{goods_type,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Goods record) {
        SQL sql = new SQL();
        sql.UPDATE("goods");
        
        if (record.getMerchant_id() != null) {
            sql.SET("merchant_id = #{merchant_id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_id() != null) {
            sql.SET("category_id = #{category_id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.SET("en_title = #{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getSell_point() != null) {
            sql.SET("sell_point = #{sell_point,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_sell_point() != null) {
            sql.SET("en_sell_point = #{en_sell_point,jdbcType=VARCHAR}");
        }
        
        if (record.getTag_id() != null) {
            sql.SET("tag_id = #{tag_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_images() != null) {
            sql.SET("goods_images = #{goods_images,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_activity() != null) {
            sql.SET("has_activity = #{has_activity,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_type() != null) {
            sql.SET("goods_type = #{goods_type,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("goods_id = #{goods_id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}