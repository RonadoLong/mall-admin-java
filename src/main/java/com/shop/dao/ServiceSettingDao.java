package com.shop.dao;

import com.shop.entity.ServiceSetting;
import com.shop.mapper.ServiceSettingMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServiceSettingDao extends ServiceSettingMapper {

    @Select("select count(id) from service_setting")
    int findCount();

    @Select("select * from service_setting limit #{pageNum},#{pageSize}")
    List<ServiceSetting> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
