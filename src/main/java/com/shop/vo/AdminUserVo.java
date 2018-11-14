package com.shop.vo;


import com.shop.entity.AdminUser;
import com.shop.entity.Menu;

import java.util.List;

public class AdminUserVo extends AdminUser {

    private List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
