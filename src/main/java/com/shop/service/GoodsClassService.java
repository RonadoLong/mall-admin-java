package com.shop.service;

import com.shop.common.exception.BaseException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.GoodsClassDao;
import com.shop.entity.GoodsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsClassService {

    @Autowired
    private GoodsClassDao classDao;

    public int findCount() {
        return classDao.findCount();
    }

    public List<GoodsClass> findList(int total, int pageNum, int pageSize) {
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null){
            return null;
        }
        return classDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
    }

    @Transactional(rollbackFor = Exception.class)
    public void addGoodsClass(GoodsClass goodsClass) {

        int result = classDao.insertSelective(goodsClass);
        if (result == 0){
            throw new BaseException("添加分类失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsClass(GoodsClass goodsClass) {

        int result = classDao.updateByPrimaryKeySelective(goodsClass);
        if (result == 0){
            throw new BaseException("更新分类失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(Long id) {
        int result = classDao.updateStatus(id);
        if (result == 0){
            throw new BaseException("更新分类失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void del(int id) {
        classDao.deleteByPrimaryKey(id);
    }

    public List<GoodsClass> findAllList() {
        return classDao.findAll();
    }
}
