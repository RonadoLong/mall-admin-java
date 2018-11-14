package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.http.JsonResult;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberRest {

    @Autowired
    private UserService userService;



    @GetMapping("list/{pageNum}/{pageSize}")
    private JsonResult findList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = userService.findList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }


}
