package com.shop.mapper;

import com.shop.entity.HomeNav;
import org.apache.ibatis.jdbc.SQL;

public class HomeNavSqlProvider {

    public String insertSelective(HomeNav record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("home_nav");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.VALUES("en_title", "#{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getImg_url() != null) {
            sql.VALUES("img_url", "#{img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getJump_url() != null) {
            sql.VALUES("jump_url", "#{jump_url,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
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

    public String updateByPrimaryKeySelective(HomeNav record) {
        SQL sql = new SQL();
        sql.UPDATE("home_nav");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getEn_title() != null) {
            sql.SET("en_title = #{en_title,jdbcType=VARCHAR}");
        }
        
        if (record.getImg_url() != null) {
            sql.SET("img_url = #{img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getJump_url() != null) {
            sql.SET("jump_url = #{jump_url,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
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
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}