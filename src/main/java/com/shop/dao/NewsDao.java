package com.shop.dao;

import com.shop.entity.News;
import com.shop.mapper.NewsMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface NewsDao extends NewsMapper {

    @Select("select count(id) from news")
    int findCount();

    @Select("select *from news order by create_time limit #{pageNum},#{pageSize}")
    List<News> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Update(" update news set status = 1 - status  where id = #{id}")
    int updateStatus(long id);
}
