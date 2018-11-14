package com.shop.dao;

import com.shop.entity.NewsCategory;
import com.shop.entity.Video;
import com.shop.mapper.VideoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface VideoDao extends VideoMapper {


    @Select("select count(id) from video")
    int findCount();

    @Select("select *from video order by create_time limit #{pageNum},#{pageSize}")
    List<Video> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Update(" update video set status = 1 - status where id = #{id}")
    int updateStatus(long id);
}
