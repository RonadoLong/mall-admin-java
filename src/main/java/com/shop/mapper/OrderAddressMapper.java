package com.shop.mapper;

import com.shop.entity.OrderAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderAddressMapper {
    @Delete({
        "delete from order_address",
        "where orderId = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into order_address (orderId, receiverName, ",
        "receiverPhone, receiverMobile, ",
        "receiverState, receiverCity, ",
        "receiverDistrict, receiverAddress, ",
        "receiverZip, createTime, ",
        "updateTime)",
        "values (#{orderId,jdbcType=VARCHAR}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{receiverPhone,jdbcType=VARCHAR}, #{receiverMobile,jdbcType=VARCHAR}, ",
        "#{receiverState,jdbcType=VARCHAR}, #{receiverCity,jdbcType=VARCHAR}, ",
        "#{receiverDistrict,jdbcType=VARCHAR}, #{receiverAddress,jdbcType=VARCHAR}, ",
        "#{receiverZip,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderAddress record);

    @InsertProvider(type=OrderAddressSqlProvider.class, method="insertSelective")
    int insertSelective(OrderAddress record);

    @Select({
        "select",
        "orderId, receiverName, receiverPhone, receiverMobile, receiverState, receiverCity, ",
        "receiverDistrict, receiverAddress, receiverZip, createTime, updateTime",
        "from order_address",
        "where orderId = #{orderId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="orderId", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="receiverName", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverPhone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverMobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverState", property="receiverState", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverCity", property="receiverCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverDistrict", property="receiverDistrict", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverAddress", property="receiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiverZip", property="receiverZip", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderAddress selectByPrimaryKey(String orderId);

    @UpdateProvider(type=OrderAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderAddress record);

    @Update({
        "update order_address",
        "set receiverName = #{receiverName,jdbcType=VARCHAR},",
          "receiverPhone = #{receiverPhone,jdbcType=VARCHAR},",
          "receiverMobile = #{receiverMobile,jdbcType=VARCHAR},",
          "receiverState = #{receiverState,jdbcType=VARCHAR},",
          "receiverCity = #{receiverCity,jdbcType=VARCHAR},",
          "receiverDistrict = #{receiverDistrict,jdbcType=VARCHAR},",
          "receiverAddress = #{receiverAddress,jdbcType=VARCHAR},",
          "receiverZip = #{receiverZip,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP}",
        "where orderId = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderAddress record);
}