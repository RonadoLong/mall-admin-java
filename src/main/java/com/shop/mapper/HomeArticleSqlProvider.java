package com.shop.mapper;

import com.shop.entity.HomeArticle;
import org.apache.ibatis.jdbc.SQL;

public class HomeArticleSqlProvider {

    public String insertSelective(HomeArticle record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("article");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRegionId() != null) {
            sql.VALUES("regionId", "#{regionId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getThumbUrl() != null) {
            sql.VALUES("thumbUrl", "#{thumbUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceTypeName() != null) {
            sql.VALUES("sourceTypeName", "#{sourceTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getReadCount() != null) {
            sql.VALUES("readCount", "#{readCount,jdbcType=INTEGER}");
        }
        
        if (record.getCommentCount() != null) {
            sql.VALUES("commentCount", "#{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.VALUES("likeCount", "#{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getViewTypeId() != null) {
            sql.VALUES("viewTypeId", "#{viewTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getIsRecommend() != null) {
            sql.VALUES("isRecommend", "#{isRecommend,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HomeArticle record) {
        SQL sql = new SQL();
        sql.UPDATE("article");
        
        if (record.getRegionId() != null) {
            sql.SET("regionId = #{regionId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getThumbUrl() != null) {
            sql.SET("thumbUrl = #{thumbUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            sql.SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceTypeName() != null) {
            sql.SET("sourceTypeName = #{sourceTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getReadCount() != null) {
            sql.SET("readCount = #{readCount,jdbcType=INTEGER}");
        }
        
        if (record.getCommentCount() != null) {
            sql.SET("commentCount = #{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.SET("likeCount = #{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getViewTypeId() != null) {
            sql.SET("viewTypeId = #{viewTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getIsRecommend() != null) {
            sql.SET("isRecommend = #{isRecommend,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}