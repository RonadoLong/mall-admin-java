package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.UserDao;
import com.shop.entity.Goods;
import com.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public JSONObject findList(int currentPage, int pageSize) {
        int total = userDao.findCount();
        PageUtils pageUtils = PageUtils.generatePage(total, currentPage, pageSize);
        if (pageUtils == null) {
            throw new NotMoreException("no more content");
        }
        List<User> userList = userDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", userList);
        jsonObject.put("total", total);
        return (JSONObject) jsonObject;
    }
}
