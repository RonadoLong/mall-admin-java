package com.shop.mapper;

import com.shop.entity.Element;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ElementMapper {
    @Delete({
        "delete from base_element",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into base_element (id, code, ",
        "type, name, uri, ",
        "menuId, parentId, ",
        "path, method, description, ",
        "createTime, createUser)",
        "values (#{id,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{uri,jdbcType=VARCHAR}, ",
        "#{menuId,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR})"
    })
    int insert(Element record);

    @InsertProvider(type=ElementSqlProvider.class, method="insertSelective")
    int insertSelective(Element record);

    @Select({
        "select",
        "id, code, type, name, uri, menuId, parentId, path, method, description, createTime, ",
        "createUser",
        "from base_element",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="uri", property="uri", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuId", property="menuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createUser", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    Element selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ElementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Element record);

    @Update({
        "update base_element",
        "set code = #{code,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "uri = #{uri,jdbcType=VARCHAR},",
          "menuId = #{menuId,jdbcType=VARCHAR},",
          "parentId = #{parentId,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createUser = #{createUser,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Element record);
}