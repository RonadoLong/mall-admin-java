package com.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.NotMoreException;
import com.shop.common.utils.PageUtils;
import com.shop.dao.OrderInfoDao;
import com.shop.dao.UserAddressDao;
import com.shop.entity.OrderInfo;
import com.shop.entity.UserAddress;
import com.shop.vo.OrderInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private UserAddressDao userAddressDao;

    public JSONObject findList(int status, int pageNum, int pageSize) {

        int total = getCount(status);
        PageUtils pageUtils = PageUtils.generatePage(total, pageNum, pageSize);
        if (pageUtils == null) {
            return null;
        }

        List<OrderInfo> orderInfos = getList(status, pageUtils);
        if (CollectionUtils.isEmpty(orderInfos)) {
            return null;
        }

        List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
        //	//状态：1未确认 2已确认 3退款 4交易成功(已收货) 5交易关闭 6无效
        //	OrderStatus int

        //	//发货状态 1未发货 2已发货 3已收货
        //	ShippingStatus int

        //	//支付状态 1未支付 2已支付
        //	PayStatus int

        orderInfos.forEach(orderInfo -> {
            UserAddress userService = userAddressDao.selectByPrimaryKey(Long.valueOf(orderInfo.getOrder_address()));
            orderInfo.setUsername(userService.getContact_name());
            String statusStr = getStatus(orderInfo);
            OrderInfoVo orderInfoVo = new OrderInfoVo();
            BeanUtils.copyProperties(orderInfo, orderInfoVo);
            orderInfoVo.setStatus(statusStr);
            orderInfoVo.setUserAddress(userService);
            orderInfoVoList.add(orderInfoVo);
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", orderInfoVoList);
        jsonObject.put("total", total);
        return jsonObject;
    }

    private String getStatus(OrderInfo orderInfo){
        if (orderInfo.getPay_status() == 1){
            return "未支付";
        }

        if (orderInfo.getPay_status() == 2 && orderInfo.getShipping_status() == 1){
            return "等待发货";
        }

        if (orderInfo.getPay_status() == 2 && orderInfo.getShipping_status() == 2){
            return "等待收货";
        }

        if (orderInfo.getPay_status() == 2 && orderInfo.getShipping_status() == 3 && orderInfo.getOrder_status() == 4){
            return "交易成功";
        }

        if (orderInfo.getOrder_status() == 3){
            return "已退款";
        }

        return "交易无效";

    }

    private int getCount(int status) {

        if (status == 0) {
            return orderInfoDao.findCount();
        }

        if (status == 1) {
            return orderInfoDao.findWaitingPayCount();
        }

        return orderInfoDao.findWaitingShippingCount();
    }

    private List<OrderInfo> getList(int status, PageUtils pageUtils) {

        if (status == 0) {
            return orderInfoDao.findList(pageUtils.getPageNum(), pageUtils.getPageSize());
        }

        if (status == 1) {
            return orderInfoDao.findWaitingPayList(pageUtils.getPageNum(), pageUtils.getPageSize());
        }

        return orderInfoDao.findWaitingShippingList(pageUtils.getPageNum(), pageUtils.getPageSize());

    }
}
