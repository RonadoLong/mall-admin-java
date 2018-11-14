package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.DBObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.ServiceClassDao;
import com.shop.entity.NewsCategory;
import com.shop.entity.ServiceCategory;
import com.shop.mono.model.ServiceClass;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.ws.Action;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ServiceClassService {

    @Autowired
    private ServiceClassDao serviceClassDao;

    private static final String COLLETION_NAME = "service_class";

    @Autowired
    private MongoTemplate mongoTemplate;

    public JSONObject findCategorysList(int pageNum, int pageSize) {
//        int total = serviceClassDao.findCount();
////        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
////        if (pageUtils == null) {
////            return  null;
////        }
////        List<ServiceCategory> categories = serviceClassDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("content", categories);
////        jsonObject.put("total", total);
////        return jsonObject;
        Query query = new Query();
        Long total = mongoTemplate.count(query, COLLETION_NAME);
        PageUtils pageUtils = PageUtils.generatePage(total.intValue(), pageNum, pageSize);
        if (pageUtils == null) {
            return null;
        }

        Sort sort = new Sort(Sort.Direction.DESC, "create_at");
        query.with(sort);
        query.skip(pageUtils.getPageNum());
        query.limit(pageUtils.getPageSize());
        List<ServiceClass> list = mongoTemplate.find(query, ServiceClass.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", list);
        return jsonObject;
    }

    public boolean saveOjb(ServiceClass serviceClass) {
        if (StringUtils.isNotBlank(serviceClass.getId())){
            Criteria criteria = new Criteria("_id").is(serviceClass.getId());
            Query query = new Query(criteria);
            Update update = new Update();
            if (StringUtils.isNotBlank(serviceClass.getName())){
                update.set("name", serviceClass.getName());
            }

            if (StringUtils.isNotBlank(serviceClass.getEn_name())){
                update.set("en_name", serviceClass.getEn_name());
            }

            if (StringUtils.isNotBlank(serviceClass.getImg_url())){
                update.set("img_url", serviceClass.getImg_url());
            }

            if (!CollectionUtils.isEmpty(serviceClass.getSettings())){
                update.set("settings", serviceClass.getSettings());
            }

            update.set("update_at", new Date(System.currentTimeMillis()));
            return mongoTemplate.updateMulti(query, update, COLLETION_NAME).isUpdateOfExisting();
        }

        serviceClass.setCreate_at(new Date(System.currentTimeMillis()));
        serviceClass.setUpdate_at(new Date(System.currentTimeMillis()));
        mongoTemplate.save(serviceClass, COLLETION_NAME);
        return true;
    }

    public boolean del(String id) {
        if (StringUtils.isBlank(id)){
            return false;
        }
        Query query = new Query(new Criteria("_id").is(id));
        return mongoTemplate.remove(query, COLLETION_NAME).isUpdateOfExisting();
    }

    public boolean updateStatus(String id, int status) {
        Criteria criteria = new Criteria("_id").is(id);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("status", status);
        update.set("update_at", new Date(System.currentTimeMillis()));
        return mongoTemplate.updateMulti(query, update, COLLETION_NAME).isUpdateOfExisting();
    }
}
