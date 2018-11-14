package com.shop.mapper;

import com.shop.entity.NotifyMsgTemplate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NotifyMsgTemplateMapper {
    @Delete({
        "delete from notify_msg_template",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into notify_msg_template (id, code, ",
        "content, createUser, ",
        "createdTime, updateUser, ",
        "updatedTime)",
        "values (#{id,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updatedTime,jdbcType=TIMESTAMP})"
    })
    int insert(NotifyMsgTemplate record);

    @InsertProvider(type=NotifyMsgTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(NotifyMsgTemplate record);

    @Select({
        "select",
        "id, code, content, createUser, createdTime, updateUser, updatedTime",
        "from notify_msg_template",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="createUser", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdTime", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateUser", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="updatedTime", property="updatedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    NotifyMsgTemplate selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NotifyMsgTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NotifyMsgTemplate record);

    @Update({
        "update notify_msg_template",
        "set code = #{code,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "createUser = #{createUser,jdbcType=VARCHAR},",
          "createdTime = #{createdTime,jdbcType=TIMESTAMP},",
          "updateUser = #{updateUser,jdbcType=VARCHAR},",
          "updatedTime = #{updatedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NotifyMsgTemplate record);
}