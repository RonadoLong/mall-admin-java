package com.shop.service;


import com.shop.dao.AdminUserDao;
import com.shop.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    public AdminUser findByNameAndPassword(String username, String password){
        return adminUserDao.findByNameAndPassword(username, password);
    }

    public AdminUser findUserByUserId(Integer userId) {
        return adminUserDao.selectByPrimaryKey(userId);
    }
}