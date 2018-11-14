package com.shop.mapper;

import com.shop.entity.OrderInfo;
import org.apache.ibatis.jdbc.SQL;

public class OrderInfoSqlProvider {

    public String insertSelective(OrderInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_info");
        
        if (record.getOrder_id() != null) {
            sql.VALUES("order_id", "#{order_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchant_id() != null) {
            sql.VALUES("merchant_id", "#{merchant_id,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_integral() != null) {
            sql.VALUES("total_integral", "#{total_integral,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_address() != null) {
            sql.VALUES("order_address", "#{order_address,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_type() != null) {
            sql.VALUES("order_type", "#{order_type,jdbcType=INTEGER}");
        }
        
        if (record.getIs_post_fee() != null) {
            sql.VALUES("is_post_fee", "#{is_post_fee,jdbcType=INTEGER}");
        }
        
        if (record.getPost_fee() != null) {
            sql.VALUES("post_fee", "#{post_fee,jdbcType=INTEGER}");
        }
        
        if (record.getCoupon_id() != null) {
            sql.VALUES("coupon_id", "#{coupon_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCoupon_paid() != null) {
            sql.VALUES("coupon_paid", "#{coupon_paid,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_count() != null) {
            sql.VALUES("goods_count", "#{goods_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_amount() != null) {
            sql.VALUES("total_amount", "#{total_amount,jdbcType=INTEGER}");
        }
        
        if (record.getReally_amount() != null) {
            sql.VALUES("really_amount", "#{really_amount,jdbcType=INTEGER}");
        }
        
        if (record.getOrder_identifier() != null) {
            sql.VALUES("order_identifier", "#{order_identifier,jdbcType=VARCHAR}");
        }
        
        if (record.getShipping_name() != null) {
            sql.VALUES("shipping_name", "#{shipping_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShipping_code() != null) {
            sql.VALUES("shipping_code", "#{shipping_code,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyer_msg() != null) {
            sql.VALUES("buyer_msg", "#{buyer_msg,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment_time() != null) {
            sql.VALUES("payment_time", "#{payment_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotal_settlement_price() != null) {
            sql.VALUES("total_settlement_price", "#{total_settlement_price,jdbcType=INTEGER}");
        }
        
        if (record.getBuyer_rate() != null) {
            sql.VALUES("buyer_rate", "#{buyer_rate,jdbcType=INTEGER}");
        }
        
        if (record.getPay_type() != null) {
            sql.VALUES("pay_type", "#{pay_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            sql.VALUES("order_status", "#{order_status,jdbcType=INTEGER}");
        }
        
        if (record.getShipping_status() != null) {
            sql.VALUES("shipping_status", "#{shipping_status,jdbcType=INTEGER}");
        }
        
        if (record.getPay_status() != null) {
            sql.VALUES("pay_status", "#{pay_status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConsign_time() != null) {
            sql.VALUES("consign_time", "#{consign_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchant_id() != null) {
            sql.SET("merchant_id = #{merchant_id,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_integral() != null) {
            sql.SET("total_integral = #{total_integral,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_address() != null) {
            sql.SET("order_address = #{order_address,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_type() != null) {
            sql.SET("order_type = #{order_type,jdbcType=INTEGER}");
        }
        
        if (record.getIs_post_fee() != null) {
            sql.SET("is_post_fee = #{is_post_fee,jdbcType=INTEGER}");
        }
        
        if (record.getPost_fee() != null) {
            sql.SET("post_fee = #{post_fee,jdbcType=INTEGER}");
        }
        
        if (record.getCoupon_id() != null) {
            sql.SET("coupon_id = #{coupon_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCoupon_paid() != null) {
            sql.SET("coupon_paid = #{coupon_paid,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_count() != null) {
            sql.SET("goods_count = #{goods_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_amount() != null) {
            sql.SET("total_amount = #{total_amount,jdbcType=INTEGER}");
        }
        
        if (record.getReally_amount() != null) {
            sql.SET("really_amount = #{really_amount,jdbcType=INTEGER}");
        }
        
        if (record.getOrder_identifier() != null) {
            sql.SET("order_identifier = #{order_identifier,jdbcType=VARCHAR}");
        }
        
        if (record.getShipping_name() != null) {
            sql.SET("shipping_name = #{shipping_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShipping_code() != null) {
            sql.SET("shipping_code = #{shipping_code,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyer_msg() != null) {
            sql.SET("buyer_msg = #{buyer_msg,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment_time() != null) {
            sql.SET("payment_time = #{payment_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotal_settlement_price() != null) {
            sql.SET("total_settlement_price = #{total_settlement_price,jdbcType=INTEGER}");
        }
        
        if (record.getBuyer_rate() != null) {
            sql.SET("buyer_rate = #{buyer_rate,jdbcType=INTEGER}");
        }
        
        if (record.getPay_type() != null) {
            sql.SET("pay_type = #{pay_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            sql.SET("order_status = #{order_status,jdbcType=INTEGER}");
        }
        
        if (record.getShipping_status() != null) {
            sql.SET("shipping_status = #{shipping_status,jdbcType=INTEGER}");
        }
        
        if (record.getPay_status() != null) {
            sql.SET("pay_status = #{pay_status,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConsign_time() != null) {
            sql.SET("consign_time = #{consign_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("order_id = #{order_id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}