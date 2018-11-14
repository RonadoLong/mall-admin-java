package com.shop.mapper;

import com.shop.entity.GoodsProperties;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsPropertiesMapper {
    @Delete({
        "delete from goods_properties",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into goods_properties (id, goodsId, ",
        "propertyName, memberPrice, ",
        "price, lowPrice, ",
        "activityPrice, discountPrice, ",
        "preSalePrice, activityEnable, ",
        "isActive, soldNumber, ",
        "stockNumber, commission, ",
        "integral, shelvesStatus, ",
        "status, updateTime, ",
        "createTime)",
        "values (#{id,jdbcType=BIGINT}, #{goodsId,jdbcType=BIGINT}, ",
        "#{propertyName,jdbcType=VARCHAR}, #{memberPrice,jdbcType=DECIMAL}, ",
        "#{price,jdbcType=DECIMAL}, #{lowPrice,jdbcType=DECIMAL}, ",
        "#{activityPrice,jdbcType=DECIMAL}, #{discountPrice,jdbcType=DECIMAL}, ",
        "#{preSalePrice,jdbcType=DECIMAL}, #{activityEnable,jdbcType=VARCHAR}, ",
        "#{isActive,jdbcType=VARCHAR}, #{soldNumber,jdbcType=INTEGER}, ",
        "#{stockNumber,jdbcType=INTEGER}, #{commission,jdbcType=DECIMAL}, ",
        "#{integral,jdbcType=INTEGER}, #{shelvesStatus,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(GoodsProperties record);

    @InsertProvider(type=GoodsPropertiesSqlProvider.class, method="insertSelective")
    int insertSelective(GoodsProperties record);

    @Select({
        "select",
        "id, goodsId, propertyName, memberPrice, price, lowPrice, activityPrice, discountPrice, ",
        "preSalePrice, activityEnable, isActive, soldNumber, stockNumber, commission, ",
        "integral, shelvesStatus, status, updateTime, createTime",
        "from goods_properties",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="goodsId", property="goodsId", jdbcType=JdbcType.BIGINT),
        @Result(column="propertyName", property="propertyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="memberPrice", property="memberPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="lowPrice", property="lowPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="activityPrice", property="activityPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discountPrice", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="preSalePrice", property="preSalePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="activityEnable", property="activityEnable", jdbcType=JdbcType.VARCHAR),
        @Result(column="isActive", property="isActive", jdbcType=JdbcType.VARCHAR),
        @Result(column="soldNumber", property="soldNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="stockNumber", property="stockNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="commission", property="commission", jdbcType=JdbcType.DECIMAL),
        @Result(column="integral", property="integral", jdbcType=JdbcType.INTEGER),
        @Result(column="shelvesStatus", property="shelvesStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    GoodsProperties selectByPrimaryKey(Long id);

    @UpdateProvider(type=GoodsPropertiesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsProperties record);

    @Update({
        "update goods_properties",
        "set goodsId = #{goodsId,jdbcType=BIGINT},",
          "propertyName = #{propertyName,jdbcType=VARCHAR},",
          "memberPrice = #{memberPrice,jdbcType=DECIMAL},",
          "price = #{price,jdbcType=DECIMAL},",
          "lowPrice = #{lowPrice,jdbcType=DECIMAL},",
          "activityPrice = #{activityPrice,jdbcType=DECIMAL},",
          "discountPrice = #{discountPrice,jdbcType=DECIMAL},",
          "preSalePrice = #{preSalePrice,jdbcType=DECIMAL},",
          "activityEnable = #{activityEnable,jdbcType=VARCHAR},",
          "isActive = #{isActive,jdbcType=VARCHAR},",
          "soldNumber = #{soldNumber,jdbcType=INTEGER},",
          "stockNumber = #{stockNumber,jdbcType=INTEGER},",
          "commission = #{commission,jdbcType=DECIMAL},",
          "integral = #{integral,jdbcType=INTEGER},",
          "shelvesStatus = #{shelvesStatus,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GoodsProperties record);
}