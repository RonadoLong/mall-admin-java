package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.http.JsonResult;
import com.shop.service.InfoService;
import com.shop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InfoRest {

    @Autowired
    private InfoService infoService;

    @Autowired
    private NewsService newsService;

    @GetMapping("/news/list/{pageNum}/{pageSize}")
    private JsonResult getNewsList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = newsService.findNewsList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

    @GetMapping("/news/del/{id}")
    private JsonResult newsDel(@PathVariable long id){
        boolean ret = newsService.deleteNews(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("/news/updateStatus/{id}")
    private JsonResult newsUpdateStatus(@PathVariable long id){
        boolean ret = newsService.updateNewsStatus(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("/news/class/list/{pageNum}/{pageSize}")
    private JsonResult getNewsclassList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = newsService.findNewCategorysList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }


    @GetMapping("/video/list/{pageNum}/{pageSize}")
    private JsonResult getVideoList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = infoService.findVideoList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

    @GetMapping("/video/del/{id}")
    private JsonResult newsvideo(@PathVariable long id){
        boolean ret = infoService.delete(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("/video/updateStatus/{id}")
    private JsonResult videoUpdateStatus(@PathVariable long id){
        boolean ret = infoService.updateStatus(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("/video/class/list/{pageNum}/{pageSize}")
    private JsonResult getVideoClassList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = infoService.findVideoCategoryList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }


}
