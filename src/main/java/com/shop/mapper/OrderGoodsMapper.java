package com.shop.mapper;

import com.shop.entity.OrderGoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderGoodsMapper {
    @Delete({
        "delete from order_goods",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into order_goods (id, order_id, ",
        "product_id, goods_title, ",
        "goods_price, total_price, ",
        "goods_image, goods_count, ",
        "goods_number, sku_id, ",
        "sku_values, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{order_id,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{goods_title,jdbcType=VARCHAR}, ",
        "#{goods_price,jdbcType=INTEGER}, #{total_price,jdbcType=INTEGER}, ",
        "#{goods_image,jdbcType=VARCHAR}, #{goods_count,jdbcType=INTEGER}, ",
        "#{goods_number,jdbcType=VARCHAR}, #{sku_id,jdbcType=BIGINT}, ",
        "#{sku_values,jdbcType=VARCHAR}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP})"
    })
    int insert(OrderGoods record);

    @InsertProvider(type=OrderGoodsSqlProvider.class, method="insertSelective")
    int insertSelective(OrderGoods record);

    @Select({
        "select",
        "id, order_id, product_id, goods_title, goods_price, total_price, goods_image, ",
        "goods_count, goods_number, sku_id, sku_values, create_time, update_time",
        "from order_goods",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="goods_title", property="goods_title", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_price", property="goods_price", jdbcType=JdbcType.INTEGER),
        @Result(column="total_price", property="total_price", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_image", property="goods_image", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_count", property="goods_count", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_number", property="goods_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="sku_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sku_values", property="sku_values", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderGoods selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderGoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderGoods record);

    @Update({
        "update order_goods",
        "set order_id = #{order_id,jdbcType=VARCHAR},",
          "product_id = #{product_id,jdbcType=BIGINT},",
          "goods_title = #{goods_title,jdbcType=VARCHAR},",
          "goods_price = #{goods_price,jdbcType=INTEGER},",
          "total_price = #{total_price,jdbcType=INTEGER},",
          "goods_image = #{goods_image,jdbcType=VARCHAR},",
          "goods_count = #{goods_count,jdbcType=INTEGER},",
          "goods_number = #{goods_number,jdbcType=VARCHAR},",
          "sku_id = #{sku_id,jdbcType=BIGINT},",
          "sku_values = #{sku_values,jdbcType=VARCHAR},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderGoods record);
}