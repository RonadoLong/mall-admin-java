package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.*;
import com.shop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {


    @Autowired
    private VideoDao videoDao;

    @Autowired
    private VideoCategoryDao videoCategoryDao;


    public JSONObject findVideoList(int pageNum, int pageSize) {
        int total = videoDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null) {
            throw new NotMoreException("no more content");
        }
        List<Video> videoList = videoDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", videoList);
        jsonObject.put("total", total);
        return jsonObject;
    }

    public JSONObject findVideoCategoryList(int pageNum, int pageSize) {
        int total = videoCategoryDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null) {
            throw new NotMoreException("no more content");
        }
        List<VideoCategory> videoCategories = videoCategoryDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", videoCategories);
        jsonObject.put("total", total);
        return  jsonObject;
    }


    public boolean delete(long id) {
        return videoDao.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateStatus(long id) {
        return videoDao.updateStatus(id) > 0;
    }

}
