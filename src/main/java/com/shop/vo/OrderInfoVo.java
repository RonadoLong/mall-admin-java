package com.shop.vo;

import com.shop.entity.OrderInfo;
import com.shop.entity.UserAddress;
import lombok.Data;

@Data
public class OrderInfoVo extends OrderInfo {

    private String phone;

    private UserAddress userAddress;

    private String status;

}
