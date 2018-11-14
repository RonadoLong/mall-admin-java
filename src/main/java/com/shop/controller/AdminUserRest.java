package com.shop.controller;

import com.alibaba.fastjson.JSONObject;

import com.shop.common.http.JsonResult;
import com.shop.config.BaseController;
import com.shop.entity.AdminUser;
import com.shop.service.AdminRoleService;
import com.shop.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AdminUserRest extends BaseController {

    @Autowired
    private AdminRoleService roleService;

    @Autowired
    private AdminUserService userService;

    @GetMapping("userInfo")
    public JsonResult userInfo(){

        int userId = this.getUserId();

//        List<Menu> roleList = roleService.findMenuByUserId(userId);
//        if (CollectionUtils.isEmpty(roleList)){
//            return JsonResult.createError("没有权限");
//        }

        AdminUser adminUser = userService.findUserByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("role", "admin");
        jsonObject.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonObject.put("name", adminUser.getUsername());
        return JsonResult.createSuccess(jsonObject);
    }
}
