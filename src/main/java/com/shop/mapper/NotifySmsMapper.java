package com.shop.mapper;

import com.shop.entity.NotifySms;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NotifySmsMapper {
    @Delete({
        "delete from notify_sms",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into notify_sms (id, mobile, ",
        "ip, templateId, ",
        "content, status, ",
        "result, createdTime, ",
        "updatedTime)",
        "values (#{id,jdbcType=INTEGER}, #{mobile,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{templateId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{result,jdbcType=VARCHAR}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{updatedTime,jdbcType=TIMESTAMP})"
    })
    int insert(NotifySms record);

    @InsertProvider(type=NotifySmsSqlProvider.class, method="insertSelective")
    int insertSelective(NotifySms record);

    @Select({
        "select",
        "id, mobile, ip, templateId, content, status, result, createdTime, updatedTime",
        "from notify_sms",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="templateId", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="result", property="result", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdTime", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updatedTime", property="updatedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    NotifySms selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NotifySmsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NotifySms record);

    @Update({
        "update notify_sms",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "templateId = #{templateId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "result = #{result,jdbcType=VARCHAR},",
          "createdTime = #{createdTime,jdbcType=TIMESTAMP},",
          "updatedTime = #{updatedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NotifySms record);
}