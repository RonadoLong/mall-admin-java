package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.NewsCategoryDao;
import com.shop.dao.NewsDao;
import com.shop.entity.News;
import com.shop.entity.NewsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewsCategoryDao newsCategoryDao;


    public JSONObject findNewsList(int pageNum, int pageSize) {
        int total = newsDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null) {
            throw new NotMoreException("no more content");
        }
        List<News> newsList = newsDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", newsList);
        jsonObject.put("total", total);
        return (JSONObject) jsonObject;
    }

    public JSONObject findNewCategorysList(int pageNum, int pageSize) {
        int total = newsCategoryDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null) {
            throw new NotMoreException("no more content");
        }
        List<NewsCategory> newsList = newsCategoryDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", newsList);
        jsonObject.put("total", total);
        return jsonObject;
    }


    public boolean deleteNews(long id) {
        return newsDao.deleteByPrimaryKey(id) > 0;
    }

    public boolean updateNewsStatus(long id) {
        return newsDao.updateStatus(id) > 0;
    }
}
