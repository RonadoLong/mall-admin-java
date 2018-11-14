package com.shop.config;


import com.shop.context.BaseContextHandler;
import org.springframework.stereotype.Component;

@Component
public class BaseController {



    /**
     * 获取地区id
     * @return
     */
    public Integer getRegionId(){
        String regionId = BaseContextHandler.getRegionId();
        if(regionId != null && regionId.length() > 0){
            return Integer.parseInt(regionId);
        }
        return 0;
    }

    /**
     * 获取当前用户id
     * @return
     */
    public int getUserId(){
        String uId = BaseContextHandler.getUserID();
        return Integer.parseInt(uId);
    }

    public String getUserName(){
        String userName=  BaseContextHandler.getUserName();
        return userName;
    }

}
