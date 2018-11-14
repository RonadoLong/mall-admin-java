package com.shop.mapper;

import com.shop.entity.UserAuth;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserAuthMapper {
    @Delete({
        "delete from user_auth",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user_auth (id, user_id, ",
        "identify_type, identify, ",
        "credential, trade_id, ",
        "update_time, status, ",
        "create_time)",
        "values (#{id,jdbcType=VARCHAR}, #{user_id,jdbcType=VARCHAR}, ",
        "#{identify_type,jdbcType=VARCHAR}, #{identify,jdbcType=VARCHAR}, ",
        "#{credential,jdbcType=VARCHAR}, #{trade_id,jdbcType=VARCHAR}, ",
        "#{update_time,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR}, ",
        "#{create_time,jdbcType=TIMESTAMP})"
    })
    int insert(UserAuth record);

    @InsertProvider(type=UserAuthSqlProvider.class, method="insertSelective")
    int insertSelective(UserAuth record);

    @Select({
        "select",
        "id, user_id, identify_type, identify, credential, trade_id, update_time, status, ",
        "create_time",
        "from user_auth",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="identify_type", property="identify_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="identify", property="identify", jdbcType=JdbcType.VARCHAR),
        @Result(column="credential", property="credential", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_id", property="trade_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP)
    })
    UserAuth selectByPrimaryKey(String id);

    @UpdateProvider(type=UserAuthSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAuth record);

    @Update({
        "update user_auth",
        "set user_id = #{user_id,jdbcType=VARCHAR},",
          "identify_type = #{identify_type,jdbcType=VARCHAR},",
          "identify = #{identify,jdbcType=VARCHAR},",
          "credential = #{credential,jdbcType=VARCHAR},",
          "trade_id = #{trade_id,jdbcType=VARCHAR},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=CHAR},",
          "create_time = #{create_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserAuth record);
}