package com.shop.dao;

import com.shop.entity.HomeCarousel;
import com.shop.mapper.HomeCarouselMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HomeCarouselDao extends HomeCarouselMapper {

    @Select(" SELECT COUNT(id) FROM home_carousel ")
    int findCount();

    @Select(" SELECT * FROM home_carousel ORDER BY sort ASC " +
            " limit #{pageNum},#{pageSize}")
    List<HomeCarousel> findList(@Param("pageNum") int pageNum,
                                @Param("pageSize") int pageSize);

    @Update(" UPDATE home_carousel SET status = 1 - status " +
            " WHERE id = #{id}")
    int updateStatus(Integer id);

    @Update(" UPDATE home_carousel SET sort = #{sort} " +
            " WHERE id = #{id} ")
    void updateSort(@Param("id") Integer id, @Param("sort") int sort);
}
