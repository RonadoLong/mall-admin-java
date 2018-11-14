package com.shop.dao;

import com.shop.entity.Video;
import com.shop.entity.VideoCategory;
import com.shop.mapper.VideoCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoCategoryDao extends VideoCategoryMapper {
    @Select("select count(id) from video_category")
    int findCount();

    @Select("select *from video_category order by create_time limit #{pageNum},#{pageSize}")
    List<VideoCategory> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
