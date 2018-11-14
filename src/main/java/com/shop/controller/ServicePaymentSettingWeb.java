package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.http.JsonResult;
import com.shop.common.http.TableResultResponse;
import com.shop.entity.HomeNav;
import com.shop.entity.ServicePaymentSetting;
import com.shop.service.ServicePaymentSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/payment/")
public class ServicePaymentSettingWeb {

    @Autowired
    private ServicePaymentSettingService servicePaymentSettingService;

    @GetMapping("list/{pageNum}/{pageSize}")
    public JsonResult getList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        int total = servicePaymentSettingService.findCount();
        List<ServicePaymentSetting> navList = servicePaymentSettingService.findList(total, pageNum, pageSize);
        if (CollectionUtils.isEmpty(navList)){
            return JsonResult.createNoContent();
        }
        TableResultResponse resultResponse = new TableResultResponse<>(total, navList);
        return JsonResult.createSuccess(resultResponse);
    }

    @PostMapping("save")
    public JsonResult addNav(@RequestBody ServicePaymentSetting servicePaymentSetting){
        if (servicePaymentSetting == null){
            return JsonResult.createParamError();
        }
        servicePaymentSettingService.save(servicePaymentSetting);
        return JsonResult.createSuccess();
    }


    @GetMapping("updateStatus/{id}")
    public JsonResult updateStatus(@PathVariable Integer id){
        servicePaymentSettingService.updateStatus(id);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateSort")
    public JsonResult updateSort(@RequestBody List<Integer> ids){
        servicePaymentSettingService.updateSort(ids);
        return JsonResult.createSuccess();
    }

    @GetMapping("doDel/{id}")
    public JsonResult del(@PathVariable Integer id){
        servicePaymentSettingService.del(id);
        return JsonResult.createSuccess();
    }
}
