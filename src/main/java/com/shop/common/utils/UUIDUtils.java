package com.shop.common.utils;

import java.util.UUID;

public class UUIDUtils {

    /**
     * 创建用户id
     * @return
     */
    public static String getAppUserId(){
       return "APP_" + UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    public static String getWxTiketUserId(){
        return "TK_" + UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    public static String getUserAythId(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
}
