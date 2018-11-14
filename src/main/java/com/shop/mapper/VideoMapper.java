package com.shop.mapper;

import com.shop.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface VideoMapper {
    @Delete({
        "delete from video",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into video (id, title, ",
        "thumb_url, author, ",
        "duration, tags, ",
        "read_count, comment_count, ",
        "like_count, category, ",
        "is_recommend, create_time, ",
        "update_time, status, ",
        "video_desc, pusher_info, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{thumb_url,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, ",
        "#{duration,jdbcType=VARCHAR}, #{tags,jdbcType=VARCHAR}, ",
        "#{read_count,jdbcType=INTEGER}, #{comment_count,jdbcType=INTEGER}, ",
        "#{like_count,jdbcType=INTEGER}, #{category,jdbcType=VARCHAR}, ",
        "#{is_recommend,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{video_desc,jdbcType=VARCHAR}, #{pusher_info,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Video record);

    @InsertProvider(type=VideoSqlProvider.class, method="insertSelective")
    int insertSelective(Video record);

    @Select({
        "select",
        "id, title, thumb_url, author, duration, tags, read_count, comment_count, like_count, ",
        "category, is_recommend, create_time, update_time, status, video_desc, pusher_info, ",
        "content",
        "from video",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumb_url", property="thumb_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="read_count", property="read_count", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_count", property="comment_count", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_recommend", property="is_recommend", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="video_desc", property="video_desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pusher_info", property="pusher_info", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Video selectByPrimaryKey(Long id);

    @UpdateProvider(type=VideoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Video record);

    @Update({
        "update video",
        "set title = #{title,jdbcType=VARCHAR},",
          "thumb_url = #{thumb_url,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "read_count = #{read_count,jdbcType=INTEGER},",
          "comment_count = #{comment_count,jdbcType=INTEGER},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR},",
          "is_recommend = #{is_recommend,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "video_desc = #{video_desc,jdbcType=VARCHAR},",
          "pusher_info = #{pusher_info,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Video record);

    @Update({
        "update video",
        "set title = #{title,jdbcType=VARCHAR},",
          "thumb_url = #{thumb_url,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "read_count = #{read_count,jdbcType=INTEGER},",
          "comment_count = #{comment_count,jdbcType=INTEGER},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR},",
          "is_recommend = #{is_recommend,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "video_desc = #{video_desc,jdbcType=VARCHAR},",
          "pusher_info = #{pusher_info,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Video record);
}