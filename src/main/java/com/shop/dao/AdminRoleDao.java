package com.shop.dao;


import com.shop.entity.Menu;
import com.shop.mapper.RoleMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminRoleDao extends RoleMapper {

    @Select(" SELECT m.* FROM base_menu m " +
            " LEFT JOIN base_role_menu rm ON rm.menuId = m.id " +
            " LEFT JOIN base_user_role ur ON ur.roleId = rm.roleId " +
            " WHERE ur.userId = #{userId} AND m.status = 1")
    List<Menu> findMenuByUserId(Integer userId);
}
