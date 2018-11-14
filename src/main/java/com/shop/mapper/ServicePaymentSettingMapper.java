package com.shop.mapper;

import com.shop.entity.ServicePaymentSetting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ServicePaymentSettingMapper {
    @Delete({
        "delete from service_payment_setting",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into service_payment_setting (id, name, ",
        "en_name, price, ",
        "time, status, create_at, ",
        "update_at)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{en_name,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER}, ",
        "#{time,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{create_at,jdbcType=TIMESTAMP}, ",
        "#{update_at,jdbcType=TIMESTAMP})"
    })
    int insert(ServicePaymentSetting record);

    @InsertProvider(type=ServicePaymentSettingSqlProvider.class, method="insertSelective")
    int insertSelective(ServicePaymentSetting record);

    @Select({
        "select",
        "id, name, en_name, price, time, status, create_at, update_at",
        "from service_payment_setting",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_name", property="en_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_at", property="create_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="update_at", jdbcType=JdbcType.TIMESTAMP)
    })
    ServicePaymentSetting selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ServicePaymentSettingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServicePaymentSetting record);

    @Update({
        "update service_payment_setting",
        "set name = #{name,jdbcType=VARCHAR},",
          "en_name = #{en_name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "time = #{time,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_at = #{create_at,jdbcType=TIMESTAMP},",
          "update_at = #{update_at,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ServicePaymentSetting record);
}