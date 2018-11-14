package com.shop.mapper;

import com.shop.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MenuMapper {
    @Delete({
        "delete from base_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into base_menu (id, title, ",
        "parentId, type, ",
        "icon, path, code, ",
        "description, updatetime, ",
        "createTime, status)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{updatetime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @Select({
        "select",
        "id, title, parentId, type, icon, path, code, description, updatetime, createTime, ",
        "status",
        "from base_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Menu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update base_menu",
        "set title = #{title,jdbcType=VARCHAR},",
          "parentId = #{parentId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}