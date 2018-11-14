package com.shop.dao;


import com.shop.entity.HomeNav;
import com.shop.mapper.HomeNavMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HomeNavDao extends HomeNavMapper {

    @Select("SELECT COUNT(id) FROM home_nav")
    int findCount();

    @Select(" SELECT * FROM home_nav " +
            " limit #{pageNum},#{pageSize}")
    List<HomeNav> findList(@Param("pageNum") int pageNum,
                           @Param("pageSize") int pageSize);

    @Update(" UPDATE home_nav SET status = 1 - status " +
            " WHERE id = #{id}")
    int updateStatus(Integer id);

    @Update(" UPDATE home_nav SET sort = #{sort} " +
            " WHERE id = #{id} ")
    void updateSort(@Param("id") Integer id, @Param("sort") int sort);
}
