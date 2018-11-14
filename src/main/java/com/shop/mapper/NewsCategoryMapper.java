package com.shop.mapper;

import com.shop.entity.NewsCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NewsCategoryMapper {
    @Delete({
        "delete from news_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into news_category (id, title, ",
        "sort, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(NewsCategory record);

    @InsertProvider(type=NewsCategorySqlProvider.class, method="insertSelective")
    int insertSelective(NewsCategory record);

    @Select({
        "select",
        "id, title, sort, create_time, update_time, status",
        "from news_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    NewsCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NewsCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NewsCategory record);

    @Update({
        "update news_category",
        "set title = #{title,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NewsCategory record);
}