package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.http.JsonResult;
import com.shop.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderInfoRest {

    @Autowired
    private OrderInfoService orderInfoService;


    @GetMapping("/list/{status}/{pageNum}/{pageSize}")
    private JsonResult getNewsList(@PathVariable int status, @PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = orderInfoService.findList(status, pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

}
