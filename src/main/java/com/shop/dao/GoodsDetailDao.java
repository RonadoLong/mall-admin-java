package com.shop.dao;


import com.shop.entity.Goods;
import com.shop.entity.GoodsDetailWithBLOBs;
import com.shop.mapper.GoodsDetailMapper;
import com.shop.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDetailDao extends GoodsDetailMapper {


    @Select(" select * from goods_detail where goods_id = #{product_id}")
    GoodsDetailWithBLOBs selectByGoodsId(Long product_id);
}
