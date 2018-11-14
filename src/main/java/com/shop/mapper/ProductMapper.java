package com.shop.mapper;

import com.shop.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductMapper {
    @Delete({
        "delete from product",
        "where product_id = #{product_id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long product_id);

    @Insert({
        "insert into product (product_id, merchant_id, ",
        "code, category_id, ",
        "title, en_title, ",
        "sell_point, en_sell_point, ",
        "postage, goods_images, ",
        "member_price, has_activity, ",
        "price, stock, low_price, ",
        "commission, activity_price, ",
        "integral, status, ",
        "create_time, update_time, ",
        "sold_count, buy_max)",
        "values (#{product_id,jdbcType=BIGINT}, #{merchant_id,jdbcType=BIGINT}, ",
        "#{code,jdbcType=VARCHAR}, #{category_id,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{en_title,jdbcType=VARCHAR}, ",
        "#{sell_point,jdbcType=VARCHAR}, #{en_sell_point,jdbcType=VARCHAR}, ",
        "#{postage,jdbcType=INTEGER}, #{goods_images,jdbcType=VARCHAR}, ",
        "#{member_price,jdbcType=INTEGER}, #{has_activity,jdbcType=INTEGER}, ",
        "#{price,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER}, #{low_price,jdbcType=INTEGER}, ",
        "#{commission,jdbcType=INTEGER}, #{activity_price,jdbcType=INTEGER}, ",
        "#{integral,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP}, ",
        "#{sold_count,jdbcType=INTEGER}, #{buy_max,jdbcType=INTEGER})"
    })
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    int insertSelective(Product record);

    @Select({
        "select",
        "product_id, merchant_id, code, category_id, title, en_title, sell_point, en_sell_point, ",
        "postage, goods_images, member_price, has_activity, price, stock, low_price, ",
        "commission, activity_price, integral, status, create_time, update_time, sold_count, ",
        "buy_max",
        "from product",
        "where product_id = #{product_id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="merchant_id", property="merchant_id", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="category_id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_title", property="en_title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sell_point", property="sell_point", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_sell_point", property="en_sell_point", jdbcType=JdbcType.VARCHAR),
        @Result(column="postage", property="postage", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_images", property="goods_images", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_price", property="member_price", jdbcType=JdbcType.INTEGER),
        @Result(column="has_activity", property="has_activity", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="low_price", property="low_price", jdbcType=JdbcType.INTEGER),
        @Result(column="commission", property="commission", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_price", property="activity_price", jdbcType=JdbcType.INTEGER),
        @Result(column="integral", property="integral", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sold_count", property="sold_count", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_max", property="buy_max", jdbcType=JdbcType.INTEGER)
    })
    Product selectByPrimaryKey(Long product_id);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set merchant_id = #{merchant_id,jdbcType=BIGINT},",
          "code = #{code,jdbcType=VARCHAR},",
          "category_id = #{category_id,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "en_title = #{en_title,jdbcType=VARCHAR},",
          "sell_point = #{sell_point,jdbcType=VARCHAR},",
          "en_sell_point = #{en_sell_point,jdbcType=VARCHAR},",
          "postage = #{postage,jdbcType=INTEGER},",
          "goods_images = #{goods_images,jdbcType=VARCHAR},",
          "member_price = #{member_price,jdbcType=INTEGER},",
          "has_activity = #{has_activity,jdbcType=INTEGER},",
          "price = #{price,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "low_price = #{low_price,jdbcType=INTEGER},",
          "commission = #{commission,jdbcType=INTEGER},",
          "activity_price = #{activity_price,jdbcType=INTEGER},",
          "integral = #{integral,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "sold_count = #{sold_count,jdbcType=INTEGER},",
          "buy_max = #{buy_max,jdbcType=INTEGER}",
        "where product_id = #{product_id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Product record);
}