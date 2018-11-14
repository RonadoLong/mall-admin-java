package com.shop.dao;


import com.shop.entity.Goods;
import com.shop.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao extends GoodsMapper {

    @Select(" SELECT count(goods_id) FROM goods ")
    int findCount();

    @Select(" SELECT * FROM goods " +
            " limit #{pageNum},#{pageSize}")
    List<Goods> findGoodsList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Update( " UPDATE goods SET status = 1-status " +
            " WHERE id = #{goodsId}")
    int updateUpAndDown(Long goodsId);
}
