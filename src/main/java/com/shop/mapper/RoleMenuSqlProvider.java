package com.shop.mapper;

import com.shop.entity.RoleMenu;
import org.apache.ibatis.jdbc.SQL;

public class RoleMenuSqlProvider {

    public String insertSelective(RoleMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("base_role_menu");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("roleId", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getMenuId() != null) {
            sql.VALUES("menuId", "#{menuId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RoleMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("base_role_menu");
        
        if (record.getRoleId() != null) {
            sql.SET("roleId = #{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getMenuId() != null) {
            sql.SET("menuId = #{menuId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}