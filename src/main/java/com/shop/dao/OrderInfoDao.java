package com.shop.dao;

import com.shop.entity.NewsCategory;
import com.shop.entity.OrderInfo;
import com.shop.mapper.OrderInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderInfoDao extends OrderInfoMapper {

    @Select("select count(order_id) from order_info")
    int findCount();

    @Select("select * from order_info order by create_time desc limit #{pageNum},#{pageSize}")
    List<OrderInfo> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Select("select count(order_id) from order_info where pay_status = 1 and order_status = 2")
    int findWaitingPayCount();

    @Select("select count(order_id) from order_info where shipping_status = 1 and pay_status = 2")
    int findWaitingShippingCount();

    @Select("select * from order_info where pay_status = 1 and order_status = 2 " +
            " order by create_time desc limit #{pageNum},#{pageSize}")
    List<OrderInfo> findWaitingPayList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Select("select * from order_info where shipping_status = 1 and pay_status = 2 " +
            " order by create_time desc limit #{pageNum},#{pageSize}")
    List<OrderInfo> findWaitingShippingList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
