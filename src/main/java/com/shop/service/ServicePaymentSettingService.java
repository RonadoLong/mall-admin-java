package com.shop.service;

import com.shop.common.utils.PageUtils;
import com.shop.dao.ServicePaymentSettingDao;
import com.shop.entity.ServicePaymentSetting;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePaymentSettingService {

    @Autowired
    private ServicePaymentSettingDao servicePaymentSettingDao;


    public int findCount() {
        return servicePaymentSettingDao.findCount();
    }

    public List<ServicePaymentSetting> findList(int total, int pageNum, int pageSize) {
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null){
            return null;
        }
        return servicePaymentSettingDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
    }

    public void save(ServicePaymentSetting servicePaymentSetting) {

        if (servicePaymentSetting.getId() != null && servicePaymentSetting.getId() != 0){
            servicePaymentSettingDao.updateByPrimaryKeySelective(servicePaymentSetting);
        }else {
            servicePaymentSettingDao.insertSelective(servicePaymentSetting);
        }
    }

    public void updateStatus(Integer id) {
        servicePaymentSettingDao.updateStatus(id);
    }

    public void updateSort(List<Integer> ids) {
    }

    public void del(Integer id) {
    }
}
