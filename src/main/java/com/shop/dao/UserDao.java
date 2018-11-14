package com.shop.dao;

import com.shop.entity.Goods;
import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends UserMapper {

    @Select(" select count(user_id) from user")
    int findCount();

    @Select(" SELECT * FROM user " +
            " limit #{pageNum},#{pageSize}")
    List<User> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
