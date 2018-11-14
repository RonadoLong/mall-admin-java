package com.shop.mapper;

import com.shop.entity.GoodsDetailWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

public class GoodsDetailSqlProvider {

    public String insertSelective(GoodsDetailWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods_detail");
        
        if (record.getDetail_id() != null) {
            sql.VALUES("detail_id", "#{detail_id,jdbcType=BIGINT}");
        }
        
        if (record.getGoods_id() != null) {
            sql.VALUES("goods_id", "#{goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoods_banners() != null) {
            sql.VALUES("goods_banners", "#{goods_banners,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getGoods_detail() != null) {
            sql.VALUES("goods_detail", "#{goods_detail,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getGoods_desc() != null) {
            sql.VALUES("goods_desc", "#{goods_desc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsDetailWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("goods_detail");
        
        if (record.getGoods_id() != null) {
            sql.SET("goods_id = #{goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoods_banners() != null) {
            sql.SET("goods_banners = #{goods_banners,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getGoods_detail() != null) {
            sql.SET("goods_detail = #{goods_detail,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getGoods_desc() != null) {
            sql.SET("goods_desc = #{goods_desc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("detail_id = #{detail_id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}