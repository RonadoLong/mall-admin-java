package com.shop.mapper;

import com.shop.entity.AdminUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AdminUserRoleMapper {
    @Delete({
        "delete from base_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into base_user_role (id, userId, ",
        "roleId, status, ",
        "createTime)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(AdminUserRole record);

    @InsertProvider(type=AdminUserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(AdminUserRole record);

    @Select({
        "select",
        "id, userId, roleId, status, createTime",
        "from base_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AdminUserRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdminUserRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminUserRole record);

    @Update({
        "update base_user_role",
        "set userId = #{userId,jdbcType=INTEGER},",
          "roleId = #{roleId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminUserRole record);
}