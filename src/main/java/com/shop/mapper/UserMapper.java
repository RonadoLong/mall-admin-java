package com.shop.mapper;

import com.shop.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{user_id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String user_id);

    @Insert({
        "insert into user (user_id, nickname, ",
        "real_name, sex, avatar, ",
        "hometown, remark, ",
        "create_time, update_time, ",
        "login_Time, is_recommend, ",
        "recommend_code, duration, ",
        "status, integral, commission, ",
        "birth)",
        "values (#{user_id,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{real_name,jdbcType=VARCHAR}, #{sex,jdbcType=CHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{hometown,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP}, ",
        "#{login_Time,jdbcType=TIMESTAMP}, #{is_recommend,jdbcType=CHAR}, ",
        "#{recommend_code,jdbcType=VARCHAR}, #{duration,jdbcType=INTEGER}, ",
        "#{status,jdbcType=CHAR}, #{integral,jdbcType=INTEGER}, #{commission,jdbcType=INTEGER}, ",
        "#{birth,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "user_id, nickname, real_name, sex, avatar, hometown, remark, create_time, update_time, ",
        "login_Time, is_recommend, recommend_code, duration, status, integral, commission, ",
        "birth",
        "from user",
        "where user_id = #{user_id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="hometown", property="hometown", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_Time", property="login_Time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_recommend", property="is_recommend", jdbcType=JdbcType.CHAR),
        @Result(column="recommend_code", property="recommend_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="integral", property="integral", jdbcType=JdbcType.INTEGER),
        @Result(column="commission", property="commission", jdbcType=JdbcType.INTEGER),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String user_id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set nickname = #{nickname,jdbcType=VARCHAR},",
          "real_name = #{real_name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=CHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "hometown = #{hometown,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "login_Time = #{login_Time,jdbcType=TIMESTAMP},",
          "is_recommend = #{is_recommend,jdbcType=CHAR},",
          "recommend_code = #{recommend_code,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=INTEGER},",
          "status = #{status,jdbcType=CHAR},",
          "integral = #{integral,jdbcType=INTEGER},",
          "commission = #{commission,jdbcType=INTEGER},",
          "birth = #{birth,jdbcType=TIMESTAMP}",
        "where user_id = #{user_id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}