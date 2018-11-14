package com.shop.entity;

import java.util.Date;

public class Goods {
    private Long goods_id;

    private Long merchant_id;

    private String code;

    private Integer category_id;

    private String title;

    private String en_title;

    private String sell_point;

    private String en_sell_point;

    private Integer tag_id;

    private String goods_images;

    private Integer has_activity;

    private Integer goods_type;

    private Integer status;

    private Date create_time;

    private Date update_time;

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
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

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getGoods_images() {
        return goods_images;
    }

    public void setGoods_images(String goods_images) {
        this.goods_images = goods_images == null ? null : goods_images.trim();
    }

    public Integer getHas_activity() {
        return has_activity;
    }

    public void setHas_activity(Integer has_activity) {
        this.has_activity = has_activity;
    }

    public Integer getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(Integer goods_type) {
        this.goods_type = goods_type;
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
}