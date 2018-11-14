package com.shop.protocol;

import com.shop.entity.Product;
import java.util.List;

public class ProductReq extends Product{

    private List<String> goods_detail;

    private List<String> goods_banners;

    private String goods_desc;

	/**
	 * @return the goods_detail
	 */
	public List<String> getGoods_detail() {
		return goods_detail;
	}

	/**
	 * @return the goods_desc
	 */
	public String getGoods_desc() {
		return goods_desc;
	}

	/**
	 * @param goods_desc the goods_desc to set
	 */
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	/**
	 * @return the goods_banners
	 */
	public List<String> getGoods_banners() {
		return goods_banners;
	}

	/**
	 * @param goods_banners the goods_banners to set
	 */
	public void setGoods_banners(List<String> goods_banners) {
		this.goods_banners = goods_banners;
	}

	/**
	 * @param goods_detail the goods_detail to set
	 */
	public void setGoods_detail(List<String> goods_detail) {
		this.goods_detail = goods_detail;
	}


}