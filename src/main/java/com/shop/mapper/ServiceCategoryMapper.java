package com.shop.mapper;

import com.shop.entity.ServiceCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ServiceCategoryMapper {
    @Delete({
        "delete from service_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into service_category (id, name, ",
        "en_name, imageurl, ",
        "settings, status, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{en_name,jdbcType=VARCHAR}, #{imageurl,jdbcType=VARCHAR}, ",
        "#{settings,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP})"
    })
    int insert(ServiceCategory record);

    @InsertProvider(type=ServiceCategorySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceCategory record);

    @Select({
        "select",
        "id, name, en_name, imageurl, settings, status, create_time, update_time",
        "from service_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_name", property="en_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageurl", property="imageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="settings", property="settings", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP)
    })
    ServiceCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ServiceCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceCategory record);

    @Update({
        "update service_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "en_name = #{en_name,jdbcType=VARCHAR},",
          "imageurl = #{imageurl,jdbcType=VARCHAR},",
          "settings = #{settings,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ServiceCategory record);
}