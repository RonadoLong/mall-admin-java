package com.shop.mapper;

import com.shop.entity.News;
import com.shop.entity.NewsWithBLOBs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NewsMapper {
    @Delete({
        "delete from news",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into news (id, title, ",
        "author, avatar, ",
        "source_type_name, read_count, ",
        "comment_count, like_count, ",
        "category, view_type, ",
        "is_recommend, create_time, ",
        "update_time, status, ",
        "thumb_url, content)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{source_type_name,jdbcType=VARCHAR}, #{read_count,jdbcType=INTEGER}, ",
        "#{comment_count,jdbcType=INTEGER}, #{like_count,jdbcType=INTEGER}, ",
        "#{category,jdbcType=VARCHAR}, #{view_type,jdbcType=INTEGER}, ",
        "#{is_recommend,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{thumb_url,jdbcType=LONGVARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(NewsWithBLOBs record);

    @InsertProvider(type=NewsSqlProvider.class, method="insertSelective")
    int insertSelective(NewsWithBLOBs record);

    @Select({
        "select",
        "id, title, author, avatar, source_type_name, read_count, comment_count, like_count, ",
        "category, view_type, is_recommend, create_time, update_time, status, thumb_url, ",
        "content",
        "from news",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_type_name", property="source_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="read_count", property="read_count", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_count", property="comment_count", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="view_type", property="view_type", jdbcType=JdbcType.INTEGER),
        @Result(column="is_recommend", property="is_recommend", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="thumb_url", property="thumb_url", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    NewsWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=NewsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NewsWithBLOBs record);

    @Update({
        "update news",
        "set title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "source_type_name = #{source_type_name,jdbcType=VARCHAR},",
          "read_count = #{read_count,jdbcType=INTEGER},",
          "comment_count = #{comment_count,jdbcType=INTEGER},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR},",
          "view_type = #{view_type,jdbcType=INTEGER},",
          "is_recommend = #{is_recommend,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "thumb_url = #{thumb_url,jdbcType=LONGVARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(NewsWithBLOBs record);

    @Update({
        "update news",
        "set title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "source_type_name = #{source_type_name,jdbcType=VARCHAR},",
          "read_count = #{read_count,jdbcType=INTEGER},",
          "comment_count = #{comment_count,jdbcType=INTEGER},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR},",
          "view_type = #{view_type,jdbcType=INTEGER},",
          "is_recommend = #{is_recommend,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(News record);
}