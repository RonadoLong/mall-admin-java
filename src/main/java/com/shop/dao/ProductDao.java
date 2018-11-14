package com.shop.dao;

import com.shop.entity.Goods;
import com.shop.entity.GoodsDetailWithBLOBs;
import com.shop.entity.Product;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.ProductSqlProvider;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductDao extends ProductMapper {


    public static final String UPDATE_PRODUCT_SET_STATUS_1_STATUS_WHERE_PRODUCT_ID_PRODUCT_ID = " UPDATE product SET status = 1 - status WHERE product_id = #{productId}";
    public static final String SELECT_FROM_PRODUCT_LIMIT_PAGE_NUM_PAGE_SIZE = " SELECT * FROM product limit #{pageNum},#{pageSize}";
    public static final String SELECT_COUNT_PRODUCT_ID_FROM_PRODUCT = " SELECT count(product_id) FROM product ";

    @InsertProvider(type = ProductSqlProvider.class, method = "insertSelective")
    @SelectKey(resultType = Long.class, before = false, keyProperty = "product_id", statement = "SELECT LAST_INSERT_ID()")
    int insertSelectiveCallBack(Product record);

    @Select(SELECT_COUNT_PRODUCT_ID_FROM_PRODUCT)
    int findCount();

    @Select(SELECT_FROM_PRODUCT_LIMIT_PAGE_NUM_PAGE_SIZE)
    List<Product> findGoodsList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Update(UPDATE_PRODUCT_SET_STATUS_1_STATUS_WHERE_PRODUCT_ID_PRODUCT_ID)
    int updateUpAndDown(Long productId);

    @Update({
            "update goods_detail",
            "update_time = #{now(),jdbcType=TIMESTAMP},",
            "goods_banners = #{goods_banners,jdbcType=LONGVARCHAR},",
            "goods_detail = #{goods_detail,jdbcType=LONGVARCHAR},",
            "goods_desc = #{goods_desc,jdbcType=LONGVARCHAR}",
            "where goods_id = #{goods_id,jdbcType=BIGINT}"
    })
    int updateByProductId(GoodsDetailWithBLOBs record);
}
