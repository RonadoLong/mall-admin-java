package com.shop.service;

import com.alibaba.fastjson.JSONObject;

import com.shop.common.exception.BaseException;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.GoodsDao;
import com.shop.dao.GoodsDetailDao;
import com.shop.dao.ProductDao;
import com.shop.entity.Goods;
import com.shop.entity.GoodsDetail;
import com.shop.entity.GoodsDetailWithBLOBs;
import com.shop.entity.Product;
import com.shop.protocol.ProductReq;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private GoodsDetailDao goodsDetailDao;

    public JSONObject findGoodsList(int currentPage, int pageSize) {
        int total = productDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, currentPage, pageSize);
        if (pageUtils == null) {
            return null;
        }
        List<Product>goodsList = productDao.findGoodsList(pageUtils.getPageNum(), pageUtils.getPageSize());
        List<ProductReq> productReqs = new ArrayList<>();
        goodsList.forEach(product -> {
            GoodsDetailWithBLOBs goodsDetail = goodsDetailDao.selectByGoodsId(product.getProduct_id());
            ProductReq productReq = new ProductReq();
            BeanUtils.copyProperties(product,productReq);
            productReq.setGoods_banners(Arrays.asList(goodsDetail.getGoods_banners().split(",")));
            productReq.setGoods_detail(Arrays.asList(goodsDetail.getGoods_detail().split(",")));
            productReq.setGoods_desc(goodsDetail.getGoods_desc());
            productReqs.add(productReq);
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", productReqs);
        jsonObject.put("total", total);
        return jsonObject;
    }

    @Transactional
    public void addGoods(ProductReq productrReq) {
        
       int ret = productDao.insertSelectiveCallBack(productrReq);
       if(ret > 0){
           GoodsDetailWithBLOBs goodsDetail = new GoodsDetailWithBLOBs();
           String goodsBanners = StringUtils.join(productrReq.getGoods_banners(), ",");
           String goodsDetails = StringUtils.join(productrReq.getGoods_detail(), ",");

           goodsDetail.setGoods_id(productrReq.getProduct_id());
           goodsDetail.setGoods_banners(goodsBanners);
           goodsDetail.setGoods_detail(goodsDetails);
           goodsDetail.setGoods_desc(productrReq.getGoods_desc());
           goodsDetailDao.insertSelective(goodsDetail);
       }
    }

    @Transactional
    public void updateGoods(ProductReq productrReq) {
        if(productrReq.getProduct_id() != null && productrReq.getProduct_id() > 0){
            int ret = productDao.updateByPrimaryKeySelective(productrReq);
            if(ret > 0){
                GoodsDetailWithBLOBs goodsDetail = new GoodsDetailWithBLOBs();
                if(!CollectionUtils.isEmpty(productrReq.getGoods_banners())){
                    String goodsBanners = StringUtils.join(productrReq.getGoods_banners(), ",");
                    goodsDetail.setGoods_banners(goodsBanners);
                }

                if(!CollectionUtils.isEmpty(productrReq.getGoods_detail())){
                    String goodsDetails = StringUtils.join(productrReq.getGoods_detail(), ",");
                    goodsDetail.setGoods_detail(goodsDetails);
                }

                if(StringUtils.isNotBlank(productrReq.getGoods_desc())){
                    goodsDetail.setGoods_desc(productrReq.getGoods_desc());
                }

                goodsDetail.setGoods_id(productrReq.getProduct_id());
                productDao.updateByProductId(goodsDetail);
            }
        }
    }

    public void updateUpAndDown(Long goodsId) {
        int ret = goodsDao.updateUpAndDown(goodsId);
        if (ret == 0){
            throw new BaseException("updateUpAndDown error");
        }
    }

    public void del(Long goodsId) {
        int ret = goodsDao.deleteByPrimaryKey(goodsId);
        if (ret == 0){
            throw new BaseException("del Goods error");
        }
    }
}
