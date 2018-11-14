package com.shop.entity;

import java.util.Date;

public class Product {
    private Long product_id;

    private Long merchant_id;

    private String code;

    private Integer category_id;

    private String title;

    private String en_title;

    private String sell_point;

    private String en_sell_point;

    private Integer postage;

    private String goods_images;

    private Integer member_price;

    private Integer has_activity;

    private Integer price;

    private Integer stock;

    private Integer low_price;

    private Integer commission;

    private Integer activity_price;

    private Integer integral;

    private Integer status;

    private Date create_time;

    private Date update_time;

    private Integer sold_count;

    private Integer buy_max;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(Long merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title == null ? null : en_title.trim();
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point == null ? null : sell_point.trim();
    }

    public String getEn_sell_point() {
        return en_sell_point;
    }

    public void setEn_sell_point(String en_sell_point) {
        this.en_sell_point = en_sell_point == null ? null : en_sell_point.trim();
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public String getGoods_images() {
        return goods_images;
    }

    public void setGoods_images(String goods_images) {
        this.goods_images = goods_images == null ? null : goods_images.trim();
    }

    public Integer getMember_price() {
        return member_price;
    }

    public void setMember_price(Integer member_price) {
        this.member_price = member_price;
    }

    public Integer getHas_activity() {
        return has_activity;
    }

    public void setHas_activity(Integer has_activity) {
        this.has_activity = has_activity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLow_price() {
        return low_price;
    }

    public void setLow_price(Integer low_price) {
        this.low_price = low_price;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getActivity_price() {
        return activity_price;
    }

    public void setActivity_price(Integer activity_price) {
        this.activity_price = activity_price;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSold_count() {
        return sold_count;
    }

    public void setSold_count(Integer sold_count) {
        this.sold_count = sold_count;
    }

    public Integer getBuy_max() {
        return buy_max;
    }

    public void setBuy_max(Integer buy_max) {
        this.buy_max = buy_max;
    }
}