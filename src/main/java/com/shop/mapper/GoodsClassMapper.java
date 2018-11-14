package com.shop.mapper;

import com.shop.entity.GoodsClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsClassMapper {
    @Delete({
        "delete from goods_nav",
        "where class_id = #{class_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer class_id);

    @Insert({
        "insert into goods_nav (class_id, title, ",
        "en_title, sort, ",
        "status, create_time, ",
        "update_time)",
        "values (#{class_id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{en_title,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, ",
        "#{status,jdbcType=BIT}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP})"
    })
    int insert(GoodsClass record);

    @InsertProvider(type=GoodsClassSqlProvider.class, method="insertSelective")
    int insertSelective(GoodsClass record);

    @Select({
        "select",
        "class_id, title, en_title, sort, status, create_time, update_time",
        "from goods_nav",
        "where class_id = #{class_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="class_id", property="class_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_title", property="en_title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP)
    })
    GoodsClass selectByPrimaryKey(Integer class_id);

    @UpdateProvider(type=GoodsClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsClass record);

    @Update({
        "update goods_nav",
        "set title = #{title,jdbcType=VARCHAR},",
          "en_title = #{en_title,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BIT},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where class_id = #{class_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsClass record);
}