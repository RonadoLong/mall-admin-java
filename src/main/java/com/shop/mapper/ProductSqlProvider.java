package com.shop.mapper;

import com.shop.entity.Product;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getProduct_id() != null) {
            sql.VALUES("product_id", "#{product_id,jdbcType=BIGINT}");
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
        
        if (record.getPostage() != null) {
            sql.VALUES("postage", "#{postage,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_images() != null) {
            sql.VALUES("goods_images", "#{goods_images,jdbcType=VARCHAR}");
        }
        
        if (record.getMember_price() != null) {
            sql.VALUES("member_price", "#{member_price,jdbcType=INTEGER}");
        }
        
        if (record.getHas_activity() != null) {
            sql.VALUES("has_activity", "#{has_activity,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLow_price() != null) {
            sql.VALUES("low_price", "#{low_price,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.VALUES("commission", "#{commission,jdbcType=INTEGER}");
        }
        
        if (record.getActivity_price() != null) {
            sql.VALUES("activity_price", "#{activity_price,jdbcType=INTEGER}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=INTEGER}");
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
        
        if (record.getSold_count() != null) {
            sql.VALUES("sold_count", "#{sold_count,jdbcType=INTEGER}");
        }
        
        if (record.getBuy_max() != null) {
            sql.VALUES("buy_max", "#{buy_max,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
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
        
        if (record.getPostage() != null) {
            sql.SET("postage = #{postage,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_images() != null) {
            sql.SET("goods_images = #{goods_images,jdbcType=VARCHAR}");
        }
        
        if (record.getMember_price() != null) {
            sql.SET("member_price = #{member_price,jdbcType=INTEGER}");
        }
        
        if (record.getHas_activity() != null) {
            sql.SET("has_activity = #{has_activity,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLow_price() != null) {
            sql.SET("low_price = #{low_price,jdbcType=INTEGER}");
        }
        
        if (record.getCommission() != null) {
            sql.SET("commission = #{commission,jdbcType=INTEGER}");
        }
        
        if (record.getActivity_price() != null) {
            sql.SET("activity_price = #{activity_price,jdbcType=INTEGER}");
        }
        
        if (record.getIntegral() != null) {
            sql.SET("integral = #{integral,jdbcType=INTEGER}");
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
        
        if (record.getSold_count() != null) {
            sql.SET("sold_count = #{sold_count,jdbcType=INTEGER}");
        }
        
        if (record.getBuy_max() != null) {
            sql.SET("buy_max = #{buy_max,jdbcType=INTEGER}");
        }
        
        sql.WHERE("product_id = #{product_id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}