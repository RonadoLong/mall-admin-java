package com.shop.mapper;

import com.shop.entity.ServiceSetting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ServiceSettingMapper {
    @Delete({
        "delete from service_setting",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into service_setting (id, name, ",
        "status, create_at, ",
        "update_at)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{create_at,jdbcType=TIMESTAMP}, ",
        "#{update_at,jdbcType=TIMESTAMP})"
    })
    int insert(ServiceSetting record);

    @InsertProvider(type=ServiceSettingSqlProvider.class, method="insertSelective")
    int insertSelective(ServiceSetting record);

    @Select({
        "select",
        "id, name, status, create_at, update_at",
        "from service_setting",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="create_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="update_at", jdbcType=JdbcType.TIMESTAMP)
    })
    ServiceSetting selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ServiceSettingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceSetting record);

    @Update({
        "update service_setting",
        "set name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_at = #{create_at,jdbcType=TIMESTAMP},",
          "update_at = #{update_at,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ServiceSetting record);
}