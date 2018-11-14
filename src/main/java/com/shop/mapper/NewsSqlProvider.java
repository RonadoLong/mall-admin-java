package com.shop.mapper;

import com.shop.entity.NewsWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

public class NewsSqlProvider {

    public String insertSelective(NewsWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("news");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_type_name() != null) {
            sql.VALUES("source_type_name", "#{source_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRead_count() != null) {
            sql.VALUES("read_count", "#{read_count,jdbcType=INTEGER}");
        }
        
        if (record.getComment_count() != null) {
            sql.VALUES("comment_count", "#{comment_count,jdbcType=INTEGER}");
        }
        
        if (record.getLike_count() != null) {
            sql.VALUES("like_count", "#{like_count,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            sql.VALUES("category", "#{category,jdbcType=VARCHAR}");
        }
        
        if (record.getView_type() != null) {
            sql.VALUES("view_type", "#{view_type,jdbcType=INTEGER}");
        }
        
        if (record.getIs_recommend() != null) {
            sql.VALUES("is_recommend", "#{is_recommend,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getThumb_url() != null) {
            sql.VALUES("thumb_url", "#{thumb_url,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NewsWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("news");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            sql.SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_type_name() != null) {
            sql.SET("source_type_name = #{source_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRead_count() != null) {
            sql.SET("read_count = #{read_count,jdbcType=INTEGER}");
        }
        
        if (record.getComment_count() != null) {
            sql.SET("comment_count = #{comment_count,jdbcType=INTEGER}");
        }
        
        if (record.getLike_count() != null) {
            sql.SET("like_count = #{like_count,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            sql.SET("category = #{category,jdbcType=VARCHAR}");
        }
        
        if (record.getView_type() != null) {
            sql.SET("view_type = #{view_type,jdbcType=INTEGER}");
        }
        
        if (record.getIs_recommend() != null) {
            sql.SET("is_recommend = #{is_recommend,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getThumb_url() != null) {
            sql.SET("thumb_url = #{thumb_url,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}