package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.http.JsonResult;
import com.shop.common.utils.PageUtils;
import com.shop.mono.model.Service;
import com.shop.mono.model.ServiceClass;
import com.shop.mono.repository.CustomerRepository;
import com.shop.service.ServiceClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceRest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ServiceClassService serviceClassService;


    @RequestMapping("/list/{pageNum}/{pageSize}")
    public JsonResult dobegin(@PathVariable int pageNum, @PathVariable int pageSize) throws Exception {

        Query query = new Query();
        Long total =  mongoTemplate.count(query, "service");
        Sort sort = new Sort(Sort.Direction.DESC, "create_at");
        PageUtils pageUtils = PageUtils.generatePage(total.intValue(), pageNum, pageSize);
        if (pageUtils == null) {
            return JsonResult.createNoContent();
        }

        query.skip(pageUtils.getPageNum());
        query.limit(pageUtils.getPageSize());
        query.with(sort);

        List<Service> list =  mongoTemplate.find(query, Service.class,"service");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", list);
        jsonObject.put("total", total);
        return JsonResult.createSuccess(jsonObject);
    }

    @GetMapping("/class/list/{pageNum}/{pageSize}")
    private JsonResult getClassList(@PathVariable int pageNum, @PathVariable int pageSize){
        JSONObject jsonObject = serviceClassService.findCategorysList(pageNum, pageSize);
        if (jsonObject == null){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(jsonObject);
    }

    @PostMapping("/class/save")
    private JsonResult saveOjb(@RequestBody ServiceClass serviceClass){
        boolean ret = serviceClassService.saveOjb(serviceClass);
        if (!ret){
            return JsonResult.createParamError();
        }
        return JsonResult.createSuccess();
    }

    @GetMapping("/class/del/{id}")
    private JsonResult del(@PathVariable String id){
        serviceClassService.del(id);
        return JsonResult.createSuccess();
    }

    @GetMapping("/class/updateStatus/{id}/{status}")
    private JsonResult updateStatus(@PathVariable String id, @PathVariable int status){

        boolean ret = serviceClassService.updateStatus(id, status);

        return JsonResult.createSuccess();
    }

    @GetMapping("/update/{id}/{status}")
    private JsonResult update(@PathVariable String id, @PathVariable int status){

        Criteria criteria = new Criteria("_id").is(id);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("status", status);
        update.set("update_at", new Date(System.currentTimeMillis()));

        boolean ret = mongoTemplate.updateMulti(query, update, "service").isUpdateOfExisting();
        if (!ret){
            return JsonResult.createParamError();
        }
        return JsonResult.createSuccess();
    }

}
