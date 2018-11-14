package com.shop.mapper;

import com.shop.entity.HomeCarousel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HomeCarouselMapper {
    @Delete({
        "delete from home_carousel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into home_carousel (id, title, ",
        "img_url, sort, status, ",
        "create_time, update_time, ",
        "url)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{img_url,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP}, ",
        "#{url,jdbcType=LONGVARCHAR})"
    })
    int insert(HomeCarousel record);

    @InsertProvider(type=HomeCarouselSqlProvider.class, method="insertSelective")
    int insertSelective(HomeCarousel record);

    @Select({
        "select",
        "id, title, img_url, sort, status, create_time, update_time, url",
        "from home_carousel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.LONGVARCHAR)
    })
    HomeCarousel selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HomeCarouselSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HomeCarousel record);

    @Update({
        "update home_carousel",
        "set title = #{title,jdbcType=VARCHAR},",
          "img_url = #{img_url,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "url = #{url,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(HomeCarousel record);

    @Update({
        "update home_carousel",
        "set title = #{title,jdbcType=VARCHAR},",
          "img_url = #{img_url,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HomeCarousel record);
}