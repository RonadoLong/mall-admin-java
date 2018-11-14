package com.shop.dao;

import com.shop.entity.ServicePaymentSetting;
import com.shop.mapper.ServicePaymentSettingMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ServicePaymentSettingDao extends ServicePaymentSettingMapper {

    @Select("select count(id) from service_payment_setting")
    int findCount();

    @Select("select * from service_payment_setting " +
            " order by create_at desc limit #{pageNum},#{pageSize}")
    List<ServicePaymentSetting> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Update(" update service_payment_setting set status = 1-status where id = #{id}")
    void updateStatus(Integer id);
}
