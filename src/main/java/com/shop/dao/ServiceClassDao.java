package com.shop.dao;

import com.shop.entity.ServiceCategory;
import com.shop.mapper.ServiceCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServiceClassDao extends ServiceCategoryMapper {

    @Select("select count(id) from service_category")
    int findCount();

    @Select("select * from service_category  limit #{pageNum},#{pageSize}")
    List<ServiceCategory> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
