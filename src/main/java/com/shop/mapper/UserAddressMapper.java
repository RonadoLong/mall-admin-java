package com.shop.mapper;

import com.shop.entity.UserAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserAddressMapper {
    @Delete({
        "delete from user_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_address (id, user_id, ",
        "contact_name, mobile, ",
        "address, state, ",
        "postal_code, status, ",
        "create_at, update_at)",
        "values (#{id,jdbcType=BIGINT}, #{user_id,jdbcType=VARCHAR}, ",
        "#{contact_name,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR}, ",
        "#{postal_code,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{create_at,jdbcType=TIMESTAMP}, #{update_at,jdbcType=TIMESTAMP})"
    })
    int insert(UserAddress record);

    @InsertProvider(type=UserAddressSqlProvider.class, method="insertSelective")
    int insertSelective(UserAddress record);

    @Select({
        "select",
        "id, user_id, contact_name, mobile, address, state, postal_code, status, create_at, ",
        "update_at",
        "from user_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="postal_code", property="postal_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="create_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="update_at", jdbcType=JdbcType.TIMESTAMP)
    })
    UserAddress selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAddress record);

    @Update({
        "update user_address",
        "set user_id = #{user_id,jdbcType=VARCHAR},",
          "contact_name = #{contact_name,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "postal_code = #{postal_code,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_at = #{create_at,jdbcType=TIMESTAMP},",
          "update_at = #{update_at,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserAddress record);
}