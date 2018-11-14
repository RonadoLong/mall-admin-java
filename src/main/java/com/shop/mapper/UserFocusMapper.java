package com.shop.mapper;

import com.shop.entity.UserFocus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserFocusMapper {
    @Delete({
        "delete from user_focus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_focus (id, type, ",
        "typeId, status, updateTime, ",
        "createTime)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{typeId,jdbcType=BIGINT}, #{status,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserFocus record);

    @InsertProvider(type=UserFocusSqlProvider.class, method="insertSelective")
    int insertSelective(UserFocus record);

    @Select({
        "select",
        "id, type, typeId, status, updateTime, createTime",
        "from user_focus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="typeId", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserFocus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserFocusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserFocus record);

    @Update({
        "update user_focus",
        "set type = #{type,jdbcType=INTEGER},",
          "typeId = #{typeId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserFocus record);
}