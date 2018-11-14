package com.shop.service;


import com.shop.dao.AdminRoleDao;
import com.shop.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    public List<Menu> findMenuByUserId(Integer userId) {

        List<Menu> menus = adminRoleDao.findMenuByUserId(userId);
        return menus;
    }
}
