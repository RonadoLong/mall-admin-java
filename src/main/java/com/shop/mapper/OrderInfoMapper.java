package com.shop.mapper;

import com.shop.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderInfoMapper {
    @Delete({
        "delete from order_info",
        "where order_id = #{order_id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String order_id);

    @Insert({
        "insert into order_info (order_id, user_id, ",
        "username, merchant_id, ",
        "total_integral, order_address, ",
        "order_type, is_post_fee, ",
        "post_fee, coupon_id, ",
        "coupon_paid, goods_count, ",
        "total_amount, really_amount, ",
        "order_identifier, shipping_name, ",
        "shipping_code, buyer_msg, ",
        "payment_time, total_settlement_price, ",
        "buyer_rate, pay_type, ",
        "order_status, shipping_status, ",
        "pay_status, create_time, ",
        "update_time, consign_time)",
        "values (#{order_id,jdbcType=VARCHAR}, #{user_id,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{merchant_id,jdbcType=VARCHAR}, ",
        "#{total_integral,jdbcType=VARCHAR}, #{order_address,jdbcType=VARCHAR}, ",
        "#{order_type,jdbcType=INTEGER}, #{is_post_fee,jdbcType=INTEGER}, ",
        "#{post_fee,jdbcType=INTEGER}, #{coupon_id,jdbcType=VARCHAR}, ",
        "#{coupon_paid,jdbcType=INTEGER}, #{goods_count,jdbcType=INTEGER}, ",
        "#{total_amount,jdbcType=INTEGER}, #{really_amount,jdbcType=INTEGER}, ",
        "#{order_identifier,jdbcType=VARCHAR}, #{shipping_name,jdbcType=VARCHAR}, ",
        "#{shipping_code,jdbcType=VARCHAR}, #{buyer_msg,jdbcType=VARCHAR}, ",
        "#{payment_time,jdbcType=TIMESTAMP}, #{total_settlement_price,jdbcType=INTEGER}, ",
        "#{buyer_rate,jdbcType=INTEGER}, #{pay_type,jdbcType=VARCHAR}, ",
        "#{order_status,jdbcType=INTEGER}, #{shipping_status,jdbcType=INTEGER}, ",
        "#{pay_status,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP}, #{consign_time,jdbcType=TIMESTAMP})"
    })
    int insert(OrderInfo record);

    @InsertProvider(type=OrderInfoSqlProvider.class, method="insertSelective")
    int insertSelective(OrderInfo record);

    @Select({
        "select",
        "order_id, user_id, username, merchant_id, total_integral, order_address, order_type, ",
        "is_post_fee, post_fee, coupon_id, coupon_paid, goods_count, total_amount, really_amount, ",
        "order_identifier, shipping_name, shipping_code, buyer_msg, payment_time, total_settlement_price, ",
        "buyer_rate, pay_type, order_status, shipping_status, pay_status, create_time, ",
        "update_time, consign_time",
        "from order_info",
        "where order_id = #{order_id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchant_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_integral", property="total_integral", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_address", property="order_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="order_type", jdbcType=JdbcType.INTEGER),
        @Result(column="is_post_fee", property="is_post_fee", jdbcType=JdbcType.INTEGER),
        @Result(column="post_fee", property="post_fee", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_id", property="coupon_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_paid", property="coupon_paid", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_count", property="goods_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount", property="total_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="really_amount", property="really_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_identifier", property="order_identifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_name", property="shipping_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_code", property="shipping_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_msg", property="buyer_msg", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_time", property="payment_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_settlement_price", property="total_settlement_price", jdbcType=JdbcType.INTEGER),
        @Result(column="buyer_rate", property="buyer_rate", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="pay_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_status", property="shipping_status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="pay_status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="consign_time", property="consign_time", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderInfo selectByPrimaryKey(String order_id);

    @UpdateProvider(type=OrderInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderInfo record);

    @Update({
        "update order_info",
        "set user_id = #{user_id,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "merchant_id = #{merchant_id,jdbcType=VARCHAR},",
          "total_integral = #{total_integral,jdbcType=VARCHAR},",
          "order_address = #{order_address,jdbcType=VARCHAR},",
          "order_type = #{order_type,jdbcType=INTEGER},",
          "is_post_fee = #{is_post_fee,jdbcType=INTEGER},",
          "post_fee = #{post_fee,jdbcType=INTEGER},",
          "coupon_id = #{coupon_id,jdbcType=VARCHAR},",
          "coupon_paid = #{coupon_paid,jdbcType=INTEGER},",
          "goods_count = #{goods_count,jdbcType=INTEGER},",
          "total_amount = #{total_amount,jdbcType=INTEGER},",
          "really_amount = #{really_amount,jdbcType=INTEGER},",
          "order_identifier = #{order_identifier,jdbcType=VARCHAR},",
          "shipping_name = #{shipping_name,jdbcType=VARCHAR},",
          "shipping_code = #{shipping_code,jdbcType=VARCHAR},",
          "buyer_msg = #{buyer_msg,jdbcType=VARCHAR},",
          "payment_time = #{payment_time,jdbcType=TIMESTAMP},",
          "total_settlement_price = #{total_settlement_price,jdbcType=INTEGER},",
          "buyer_rate = #{buyer_rate,jdbcType=INTEGER},",
          "pay_type = #{pay_type,jdbcType=VARCHAR},",
          "order_status = #{order_status,jdbcType=INTEGER},",
          "shipping_status = #{shipping_status,jdbcType=INTEGER},",
          "pay_status = #{pay_status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "consign_time = #{consign_time,jdbcType=TIMESTAMP}",
        "where order_id = #{order_id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderInfo record);
}