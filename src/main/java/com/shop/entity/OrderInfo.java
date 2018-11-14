package com.shop.entity;

import java.util.Date;

public class OrderInfo {
    private String order_id;

    private String user_id;

    private String username;

    private String merchant_id;

    private String total_integral;

    private String order_address;

    private Integer order_type;

    private Integer is_post_fee;

    private Integer post_fee;

    private String coupon_id;

    private Integer coupon_paid;

    private Integer goods_count;

    private Integer total_amount;

    private Integer really_amount;

    private String order_identifier;

    private String shipping_name;

    private String shipping_code;

    private String buyer_msg;

    private Date payment_time;

    private Integer total_settlement_price;

    private Integer buyer_rate;

    private String pay_type;

    private Integer order_status;

    private Integer shipping_status;

    private Integer pay_status;

    private Date create_time;

    private Date update_time;

    private Date consign_time;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id == null ? null : merchant_id.trim();
    }

    public String getTotal_integral() {
        return total_integral;
    }

    public void setTotal_integral(String total_integral) {
        this.total_integral = total_integral == null ? null : total_integral.trim();
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address == null ? null : order_address.trim();
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Integer getIs_post_fee() {
        return is_post_fee;
    }

    public void setIs_post_fee(Integer is_post_fee) {
        this.is_post_fee = is_post_fee;
    }

    public Integer getPost_fee() {
        return post_fee;
    }

    public void setPost_fee(Integer post_fee) {
        this.post_fee = post_fee;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id == null ? null : coupon_id.trim();
    }

    public Integer getCoupon_paid() {
        return coupon_paid;
    }

    public void setCoupon_paid(Integer coupon_paid) {
        this.coupon_paid = coupon_paid;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public Integer getReally_amount() {
        return really_amount;
    }

    public void setReally_amount(Integer really_amount) {
        this.really_amount = really_amount;
    }

    public String getOrder_identifier() {
        return order_identifier;
    }

    public void setOrder_identifier(String order_identifier) {
        this.order_identifier = order_identifier == null ? null : order_identifier.trim();
    }

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name == null ? null : shipping_name.trim();
    }

    public String getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(String shipping_code) {
        this.shipping_code = shipping_code == null ? null : shipping_code.trim();
    }

    public String getBuyer_msg() {
        return buyer_msg;
    }

    public void setBuyer_msg(String buyer_msg) {
        this.buyer_msg = buyer_msg == null ? null : buyer_msg.trim();
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public Integer getTotal_settlement_price() {
        return total_settlement_price;
    }

    public void setTotal_settlement_price(Integer total_settlement_price) {
        this.total_settlement_price = total_settlement_price;
    }

    public Integer getBuyer_rate() {
        return buyer_rate;
    }

    public void setBuyer_rate(Integer buyer_rate) {
        this.buyer_rate = buyer_rate;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type == null ? null : pay_type.trim();
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Integer getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(Integer shipping_status) {
        this.shipping_status = shipping_status;
    }

    public Integer getPay_status() {
        return pay_status;
    }

    public void setPay_status(Integer pay_status) {
        this.pay_status = pay_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getConsign_time() {
        return consign_time;
    }

    public void setConsign_time(Date consign_time) {
        this.consign_time = consign_time;
    }
}