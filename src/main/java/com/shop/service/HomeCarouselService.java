package com.shop.service;


import com.shop.common.exception.BaseException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.HomeCarouselDao;
import com.shop.entity.HomeCarousel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HomeCarouselService {

    @Autowired
    private HomeCarouselDao carouselDao;

    public int findCount() {
        return carouselDao.findCount();
    }

    public List<HomeCarousel> findList(int total, int pageNum, int pageSize) {

        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null){
            return null;
        }
        return carouselDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
    }

    public void addCarousel(HomeCarousel homeCarousel) {
        int result = carouselDao.insertSelective(homeCarousel);
        if (result == 0){
            throw new BaseException("添加首页轮播出错");
        }
    }

    public void updateCarousel(HomeCarousel homeCarousel) {
        int result = carouselDao.updateByPrimaryKeySelective(homeCarousel);
        if (result == 0){
            throw new BaseException("更新首页轮播出错");
        }
    }

    public void updateStatus(Integer id) {
        int result = carouselDao.updateStatus(id);
        if (result == 0){
            throw new BaseException("下架出错");
        }
    }

    public void updateSort(List<Integer> ids) {
       try {
           for(int sort = 0; sort < ids.size(); sort ++){
               Integer id = ids.get(sort);
               carouselDao.updateSort(id, sort);
           }
       }catch (Exception e){
           throw new BaseException("更新顺序失败");
       }
    }

    public void delete(Integer id) {
        carouselDao.deleteByPrimaryKey(id);
    }
}
