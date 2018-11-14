package com.shop.entity;

public class GoodsDetailWithBLOBs extends GoodsDetail {
    private String goods_banners;

    private String goods_detail;

    private String goods_desc;

    public String getGoods_banners() {
        return goods_banners;
    }

    public void setGoods_banners(String goods_banners) {
        this.goods_banners = goods_banners == null ? null : goods_banners.trim();
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail == null ? null : goods_detail.trim();
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc == null ? null : goods_desc.trim();
    }
}