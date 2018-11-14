package com.shop.dao;

import com.shop.entity.GoodsClass;
import com.shop.mapper.GoodsClassMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsClassDao extends GoodsClassMapper {

    @Select(" SELECT COUNT(class_id) FROM goods_nav  ")
    int findCount();

    @Select(" SELECT * FROM goods_nav " +
            " ORDER BY sort ASC, create_time DESC " +
            " limit #{pageNum},#{pageSize}")
    List<GoodsClass> findList(@Param("pageNum") int pageNum,
                              @Param("pageSize") int pageSize);

    @Update(" UPDATE goods_nav SET status = 1 - status " +
            " WHERE class_id = #{id}")
    int updateStatus(Long id);

    @Select("select * from goods_nav where status = 1")
    List<GoodsClass> findAll();
}
