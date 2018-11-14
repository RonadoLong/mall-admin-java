package com.shop.controller;


import com.alibaba.fastjson.JSONObject;

import com.shop.common.http.JsonResult;
import com.shop.entity.Goods;
import com.shop.entity.Product;
import com.shop.protocol.ProductReq;
import com.shop.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goods")
@Api(tags = "商品相关接口")
public class GoodsRest {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("list/{pageNum}/{pageSize}")
    private JsonResult findList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = goodsService.findGoodsList(pageNum, pageSize);
        if(jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

    @PostMapping("addGoods")
    private JsonResult addGoods(@RequestBody ProductReq productReq){
        if (productReq == null){
            return JsonResult.createParamError();
        }
        goodsService.addGoods(productReq);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateGoods")
    private JsonResult updateGoods(@RequestBody ProductReq productReq){
        if (productReq == null){
            return JsonResult.createParamError();
        }
        goodsService.updateGoods(productReq);
        return JsonResult.createSuccess();
    }

    @GetMapping("updateUpAndDown/{goodsId}")
    private JsonResult updateUpAndDown(@PathVariable Long goodsId){
        goodsService.updateUpAndDown(goodsId);
        return JsonResult.createSuccess();
    }

    @GetMapping("del/{goodsId}")
    private JsonResult del(@PathVariable Long goodsId){
        goodsService.del(goodsId);
        return JsonResult.createSuccess();
    }

}
