package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.DBObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.http.JsonResult;
import com.shop.common.utils.PageUtils;
import com.shop.dao.ServiceSettingDao;
import com.shop.mono.model.ServiceSetting;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceSettingService {

    @Autowired
    private ServiceSettingDao serviceSettingDao;

    private static final String COLLECTION_NAME = "service_setting";

    @Autowired
    private MongoTemplate mongoTemplate;

//
//    public JSONObject findList(int pageNum, int pageSize) {
//        int total = serviceSettingDao.findCount();
//        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
//        if (pageUtils == null) {
//            return null;
//        }
//        List<ServiceSetting> serviceSettings = serviceSettingDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("content", serviceSettings);
//        jsonObject.put("total", total);
//        return jsonObject;
//    }

    public JSONObject findSettingList(int pageNum, int pageSize) {

        Query query = new Query();
        Long total =  mongoTemplate.count(query, COLLECTION_NAME);
        Sort sort = new Sort(Sort.Direction.DESC, "create_at");
        PageUtils pageUtils = PageUtils.generatePage(total.intValue(), pageNum, pageSize);
        if (pageUtils == null) {
            return null;
        }
        query.skip(pageUtils.getPageNum());
        query.limit(pageUtils.getPageSize());
        query.with(sort);

        List<ServiceSetting> list =  mongoTemplate.find(query, ServiceSetting.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", list);
        jsonObject.put("total", total);
        return jsonObject;
    }

    public boolean saveInsert(ServiceSetting serviceSetting) {
        if (StringUtils.isNotBlank(serviceSetting.getId())){
            Criteria criteria = new Criteria("_id").is(serviceSetting.getId());
            Query query = new Query(criteria);
            Update update = new Update();
            if (StringUtils.isNotBlank(serviceSetting.getName())){
                update.set("name", serviceSetting.getName());
                update.set("update_at", new Date(System.currentTimeMillis()));
            }else {
                return false;
            }
            return mongoTemplate.updateMulti(query, update, COLLECTION_NAME).isUpdateOfExisting();
        }

        serviceSetting.setCreate_at(new Date(System.currentTimeMillis()));
        serviceSetting.setUpdate_at(new Date(System.currentTimeMillis()));
        mongoTemplate.save(serviceSetting, COLLECTION_NAME);
        return true;
    }

    public boolean updateStatus(ServiceSetting serviceSetting) {
        Criteria criteria = new Criteria("_id").is(serviceSetting.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("status", serviceSetting.getStatus());
        update.set("update_at", new Date(System.currentTimeMillis()));
        return mongoTemplate.updateMulti(query, update, COLLECTION_NAME).isUpdateOfExisting();
    }

    public boolean del(String id) {
        Criteria criteria = new Criteria("_id").is(id);
        Query query = new Query(criteria);
        return mongoTemplate.remove(query, COLLECTION_NAME).isUpdateOfExisting();
    }

//    public boolean save(ServiceSetting serviceSetting) {
//        if (serviceSetting.getId() != null && serviceSetting.getId() != 0){
//             return serviceSettingDao.updateByPrimaryKeySelective(serviceSetting) > 0;
//        }
//        return serviceSettingDao.insertSelective(serviceSetting) > 0;
//    }
}
