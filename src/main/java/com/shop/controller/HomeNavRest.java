package com.shop.controller;


import com.shop.common.http.JsonResult;
import com.shop.common.http.TableResultResponse;
import com.shop.entity.HomeNav;
import com.shop.service.HomeNavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nav")
@Api(tags = "首页轮播图")
public class HomeNavRest {

    @Autowired
    private HomeNavService navService;

    @GetMapping("list/{pageNum}/{pageSize}")
    public JsonResult getList(@PathVariable("pageNum") int pageNum,
                              @PathVariable("pageSize") int pageSize){

        int total = navService.findCount();
        List<HomeNav> navList = navService.findList(total, pageNum, pageSize);
        if (CollectionUtils.isEmpty(navList)){
            return JsonResult.createNoContent();
        }
        TableResultResponse resultResponse = new TableResultResponse<>(total, navList);
        return JsonResult.createSuccess(resultResponse);
    }

    @PostMapping("addNav")
    public JsonResult addNav(@RequestBody HomeNav homeNav){
        if (homeNav == null){
            return JsonResult.createParamError();
        }
        navService.addNav(homeNav);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateNav")
    public JsonResult updateNav(@RequestBody HomeNav homeNav){
        if (homeNav == null){
            return JsonResult.createParamError();
        }
        navService.updateNav(homeNav);
        return JsonResult.createSuccess();
    }

    @GetMapping("updateStatus/{id}")
    public JsonResult updateStatus(@PathVariable Integer id){
        navService.updateStatus(id);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateSort")
    public JsonResult updateSort(@RequestBody List<Integer> ids){
        navService.updateSort(ids);
        return JsonResult.createSuccess();
    }

    @GetMapping("doDel/{id}")
    public JsonResult del(@PathVariable Integer id){
        navService.del(id);
        return JsonResult.createSuccess();
    }
}
