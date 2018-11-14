package com.shop.dao;

import com.shop.entity.News;
import com.shop.entity.NewsCategory;
import com.shop.mapper.NewsCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsCategoryDao extends NewsCategoryMapper {

    @Select("select count(id) from news_category")
    int findCount();

    @Select("select *from news_category order by create_time limit #{pageNum},#{pageSize}")
    List<NewsCategory> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
