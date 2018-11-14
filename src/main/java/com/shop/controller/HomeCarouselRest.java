package com.shop.controller;


import com.shop.common.http.JsonResult;
import com.shop.common.http.TableResultResponse;
import com.shop.config.BaseController;
import com.shop.entity.HomeCarousel;
import com.shop.service.HomeCarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carousel")
@Api(tags = "首页分类")
public class HomeCarouselRest extends BaseController {

    @Autowired
    private HomeCarouselService carouselService;

    @GetMapping("list/{pageNum}/{pageSize}")
    public JsonResult getList(@PathVariable("pageNum") int pageNum,
                              @PathVariable("pageSize") int pageSize){

        int total = carouselService.findCount();
        List<HomeCarousel> navList = carouselService.findList(total, pageNum, pageSize);
        if (CollectionUtils.isEmpty(navList)){
            return JsonResult.createNoContent();
        }
        TableResultResponse resultResponse = new TableResultResponse<>(total, navList);
        return JsonResult.createSuccess(resultResponse);
    }

    @PostMapping("addCarousel")
    public JsonResult addCarousel(@RequestBody HomeCarousel carousel){
        if (carousel == null){
            return JsonResult.createParamError();
        }
        carouselService.addCarousel(carousel);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateCarousel")
    public JsonResult updateCarousel(@RequestBody HomeCarousel carousel){
        if (carousel == null){
            return JsonResult.createParamError();
        }
        carouselService.updateCarousel(carousel);
        return JsonResult.createSuccess();
    }

    @GetMapping("updateStatus/{id}")
    public JsonResult updateStatus(@PathVariable Integer id){
        carouselService.updateStatus(id);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateSort")
    public JsonResult updateSort(@RequestBody List<Integer> ids){
        carouselService.updateSort(ids);
        return JsonResult.createSuccess();
    }

    @GetMapping("doDel/{id}")
    public JsonResult doDel(@PathVariable Integer id){
        carouselService.delete(id);
        return JsonResult.createSuccess();
    }

}
