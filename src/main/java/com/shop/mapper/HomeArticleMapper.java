package com.shop.mapper;

import com.shop.entity.HomeArticle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HomeArticleMapper {
    @Delete({
        "delete from article",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into article (id, regionId, ",
        "title, thumbUrl, ",
        "author, avatar, ",
        "sourceTypeName, readCount, ",
        "commentCount, likeCount, ",
        "viewTypeId, isRecommend, ",
        "createTime, updateTime, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{regionId,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{thumbUrl,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{sourceTypeName,jdbcType=VARCHAR}, #{readCount,jdbcType=INTEGER}, ",
        "#{commentCount,jdbcType=INTEGER}, #{likeCount,jdbcType=INTEGER}, ",
        "#{viewTypeId,jdbcType=INTEGER}, #{isRecommend,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(HomeArticle record);

    @InsertProvider(type=HomeArticleSqlProvider.class, method="insertSelective")
    int insertSelective(HomeArticle record);

    @Select({
        "select",
        "id, regionId, title, thumbUrl, author, avatar, sourceTypeName, readCount, commentCount, ",
        "likeCount, viewTypeId, isRecommend, createTime, updateTime, status",
        "from article",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="regionId", property="regionId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbUrl", property="thumbUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sourceTypeName", property="sourceTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="readCount", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="commentCount", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="likeCount", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="viewTypeId", property="viewTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="isRecommend", property="isRecommend", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    HomeArticle selectByPrimaryKey(Long id);

    @UpdateProvider(type=HomeArticleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HomeArticle record);

    @Update({
        "update article",
        "set regionId = #{regionId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "thumbUrl = #{thumbUrl,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "sourceTypeName = #{sourceTypeName,jdbcType=VARCHAR},",
          "readCount = #{readCount,jdbcType=INTEGER},",
          "commentCount = #{commentCount,jdbcType=INTEGER},",
          "likeCount = #{likeCount,jdbcType=INTEGER},",
          "viewTypeId = #{viewTypeId,jdbcType=INTEGER},",
          "isRecommend = #{isRecommend,jdbcType=INTEGER},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HomeArticle record);
}