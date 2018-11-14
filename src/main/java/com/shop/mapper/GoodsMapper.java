package com.shop.mapper;

import com.shop.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsMapper {
    @Delete({
        "delete from goods",
        "where goods_id = #{goods_id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long goods_id);

    @Insert({
        "insert into goods (goods_id, merchant_id, ",
        "code, category_id, ",
        "title, en_title, ",
        "sell_point, en_sell_point, ",
        "tag_id, goods_images, ",
        "has_activity, goods_type, ",
        "status, create_time, ",
        "update_time)",
        "values (#{goods_id,jdbcType=BIGINT}, #{merchant_id,jdbcType=BIGINT}, ",
        "#{code,jdbcType=VARCHAR}, #{category_id,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{en_title,jdbcType=VARCHAR}, ",
        "#{sell_point,jdbcType=VARCHAR}, #{en_sell_point,jdbcType=VARCHAR}, ",
        "#{tag_id,jdbcType=INTEGER}, #{goods_images,jdbcType=VARCHAR}, ",
        "#{has_activity,jdbcType=INTEGER}, #{goods_type,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP})"
    })
    int insert(Goods record);

    @InsertProvider(type=GoodsSqlProvider.class, method="insertSelective")
    int insertSelective(Goods record);

    @Select({
        "select",
        "goods_id, merchant_id, code, category_id, title, en_title, sell_point, en_sell_point, ",
        "tag_id, goods_images, has_activity, goods_type, status, create_time, update_time",
        "from goods",
        "where goods_id = #{goods_id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="merchant_id", property="merchant_id", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="category_id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_title", property="en_title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sell_point", property="sell_point", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_sell_point", property="en_sell_point", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_id", property="tag_id", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_images", property="goods_images", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_activity", property="has_activity", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_type", property="goods_type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP)
    })
    Goods selectByPrimaryKey(Long goods_id);

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Goods record);

    @Update({
        "update goods",
        "set merchant_id = #{merchant_id,jdbcType=BIGINT},",
          "code = #{code,jdbcType=VARCHAR},",
          "category_id = #{category_id,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "en_title = #{en_title,jdbcType=VARCHAR},",
          "sell_point = #{sell_point,jdbcType=VARCHAR},",
          "en_sell_point = #{en_sell_point,jdbcType=VARCHAR},",
          "tag_id = #{tag_id,jdbcType=INTEGER},",
          "goods_images = #{goods_images,jdbcType=VARCHAR},",
          "has_activity = #{has_activity,jdbcType=INTEGER},",
          "goods_type = #{goods_type,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where goods_id = #{goods_id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Goods record);
}