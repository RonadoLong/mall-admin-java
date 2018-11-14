package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.http.JsonResult;
import com.shop.mono.model.ServiceSetting;
import com.shop.service.ServiceSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service/setting")
public class ServiceSettingRest {

    @Autowired
    private ServiceSettingService serviceSettingService;

    @GetMapping("list/{pageNum}/{pageSize}")
    public JsonResult getList(@PathVariable int pageNum, @PathVariable int pageSize) {
        JSONObject jsonObject = serviceSettingService.findSettingList(pageNum, pageSize);
        if (jsonObject == null) {
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

    @PostMapping("save")
    public JsonResult save(@RequestBody ServiceSetting serviceSetting) {
        boolean ret = serviceSettingService.saveInsert(serviceSetting);
        if (!ret) {
            return JsonResult.createParamError();
        }
        return JsonResult.createSuccess();
    }

    @PostMapping("updateStatus")
    public JsonResult updateStatus(@RequestBody ServiceSetting serviceSetting) {
        boolean ret = serviceSettingService.updateStatus(serviceSetting);

        return JsonResult.createSuccess();
    }

    @GetMapping("del/{id}")
    public JsonResult del(@PathVariable String id) {
        boolean ret = serviceSettingService.del(id);

        return JsonResult.createSuccess();
    }
}
