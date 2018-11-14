package com.shop.dao;

import com.shop.entity.AdminUser;
import com.shop.mapper.AdminUserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserDao extends AdminUserMapper {

    @Select({
            "select * from sys_user ",
            "where username = #{username} and password = #{password} AND status = 1 "
    })
    AdminUser findByNameAndPassword(@Param("username") String username,
                                    @Param("password") String password);
}
