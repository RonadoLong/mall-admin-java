package com.shop.mapper;

import com.shop.entity.GoodsDetail;
import com.shop.entity.GoodsDetailWithBLOBs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsDetailMapper {
    @Delete({
        "delete from goods_detail",
        "where detail_id = #{detail_id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long detail_id);

    @Insert({
        "insert into goods_detail (detail_id, goods_id, ",
        "create_time, update_time, ",
        "goods_banners, goods_detail, ",
        "goods_desc)",
        "values (#{detail_id,jdbcType=BIGINT}, #{goods_id,jdbcType=BIGINT}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP}, ",
        "#{goods_banners,jdbcType=LONGVARCHAR}, #{goods_detail,jdbcType=LONGVARCHAR}, ",
        "#{goods_desc,jdbcType=LONGVARCHAR})"
    })
    int insert(GoodsDetailWithBLOBs record);

    @InsertProvider(type=GoodsDetailSqlProvider.class, method="insertSelective")
    int insertSelective(GoodsDetailWithBLOBs record);

    @Select({
        "select",
        "detail_id, goods_id, create_time, update_time, goods_banners, goods_detail, ",
        "goods_desc",
        "from goods_detail",
        "where detail_id = #{detail_id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="detail_id", property="detail_id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="goods_banners", property="goods_banners", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="goods_detail", property="goods_detail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="goods_desc", property="goods_desc", jdbcType=JdbcType.LONGVARCHAR)
    })
    GoodsDetailWithBLOBs selectByPrimaryKey(Long detail_id);

    @UpdateProvider(type=GoodsDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsDetailWithBLOBs record);

    @Update({
        "update goods_detail",
        "set goods_id = #{goods_id,jdbcType=BIGINT},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "goods_banners = #{goods_banners,jdbcType=LONGVARCHAR},",
          "goods_detail = #{goods_detail,jdbcType=LONGVARCHAR},",
          "goods_desc = #{goods_desc,jdbcType=LONGVARCHAR}",
        "where detail_id = #{detail_id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(GoodsDetailWithBLOBs record);

    @Update({
        "update goods_detail",
        "set goods_id = #{goods_id,jdbcType=BIGINT},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where detail_id = #{detail_id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GoodsDetail record);
}