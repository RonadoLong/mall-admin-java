package com.shop.controller;


import com.shop.common.http.JsonResult;
import com.shop.common.http.TableResultResponse;
import com.shop.entity.GoodsClass;
import com.shop.service.GoodsClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goodsClass")
public class GoodsClassRest {

    @Autowired
    private GoodsClassService classService;

    @GetMapping("list/{pageNum}/{pageSize}")
    public JsonResult getList(@PathVariable("pageNum") int pageNum,
                              @PathVariable("pageSize") int pageSize){

        int total = classService.findCount();
        List<GoodsClass> classes = classService.findList(total, pageNum, pageSize);
        if (CollectionUtils.isEmpty(classes)){
            return JsonResult.createNoContent();
        }
        TableResultResponse resultResponse = new TableResultResponse<GoodsClass>(total, classes);
        return JsonResult.createSuccess(resultResponse);
    }

    @GetMapping("getTreeList")
    public JsonResult getTreeList(){
        List<GoodsClass> classes = classService.findAllList();
        return JsonResult.createSuccess(classes);
    }


    @PostMapping("addGoodsClass")
    public JsonResult addGoodsClass(@RequestBody GoodsClass goodsClass){
        if (goodsClass == null){
            return JsonResult.createParamError();
        }
        classService.addGoodsClass(goodsClass);
        return JsonResult.createSuccess();
    }

    @PostMapping("updateGoodsClass")
    public JsonResult updateGoodsClass(@RequestBody GoodsClass goodsClass){
        if (goodsClass == null){
            return JsonResult.createParamError();
        }
        classService.updateGoodsClass(goodsClass);
        return JsonResult.createSuccess();
    }

    @GetMapping("updateStatus/{id}")
    public JsonResult updateStatus(@PathVariable Long id){
        classService.updateStatus(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("del/{id}")
    public JsonResult del(@PathVariable int id){
        classService.del(id);
        return JsonResult.createSuccess();
    }


}
