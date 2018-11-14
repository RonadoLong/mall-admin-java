package com.shop.mapper;

import com.shop.entity.GoodsClass;
import org.apache.ibatis.jdbc.SQL;

public class GoodsClassSqlProvider {

    public String insertSelective(GoodsClass record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods_nav");
        
        if (record.getClass_id() != null) {
            sql.VALUES("class_id", "#{class_id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.VALUES("en_title", "#{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=BIT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsClass record) {
        SQL sql = new SQL();
        sql.UPDATE("goods_nav");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.SET("en_title = #{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=BIT}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("class_id = #{class_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}