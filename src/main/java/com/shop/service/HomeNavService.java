package com.shop.service;


import com.shop.common.exception.BaseException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.HomeNavDao;
import com.shop.entity.HomeNav;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HomeNavService {

    @Autowired
    private HomeNavDao homeNavDao;


    public List<HomeNav> findList(int total, int pageNum, int pageSize) {

        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null){
            return null;
        }
        return homeNavDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
    }

    public int findCount() {
        return homeNavDao.findCount();
    }

    public void addNav(HomeNav homeNav) {
        int result = homeNavDao.insertSelective(homeNav);
        if (result == 0){
            throw new BaseException("添加首页分类出错");
        }
    }

    public void updateNav(HomeNav homeNav) {
        int result = homeNavDao.updateByPrimaryKeySelective(homeNav);
        if (result == 0){
            throw new BaseException("更新首页分类出错");
        }
    }

    public void updateStatus(Integer id) {
        int result = homeNavDao.updateStatus(id);
        if (result == 0){
            throw new BaseException("更新首页分类出错");
        }
    }

    public void updateSort(List<Integer> ids) {

        try {
            for(int sort = 0; sort < ids.size(); sort ++){
                Integer id = ids.get(sort);
                homeNavDao.updateSort(id, sort);
            }
        }catch (Exception e){
            throw new BaseException("更新顺序失败");
        }
    }

    public void del(Integer id) {
        homeNavDao.deleteByPrimaryKey(id);
    }
}
