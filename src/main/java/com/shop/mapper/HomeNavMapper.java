package com.shop.mapper;

import com.shop.entity.HomeNav;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HomeNavMapper {
    @Delete({
        "delete from home_nav",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into home_nav (id, title, ",
        "en_title, img_url, ",
        "type, jump_url, ",
        "sort, status, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{en_title,jdbcType=VARCHAR}, #{img_url,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{jump_url,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP})"
    })
    int insert(HomeNav record);

    @InsertProvider(type=HomeNavSqlProvider.class, method="insertSelective")
    int insertSelective(HomeNav record);

    @Select({
        "select",
        "id, title, en_title, img_url, type, jump_url, sort, status, create_time, update_time",
        "from home_nav",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_title", property="en_title", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="jump_url", property="jump_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP)
    })
    HomeNav selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HomeNavSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HomeNav record);

    @Update({
        "update home_nav",
        "set title = #{title,jdbcType=VARCHAR},",
          "en_title = #{en_title,jdbcType=VARCHAR},",
          "img_url = #{img_url,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "jump_url = #{jump_url,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HomeNav record);
}