package com.shop.context;



import com.shop.common.exception.BaseException;
import com.shop.common.utils.CodeConstaint;
import com.shop.common.utils.StringHelper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseContextHandler {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getUserID(){
        Object value = get(CodeConstaint.CONTEXT_KEY_USER_ID);
        return StringHelper.getObjectValue(value);
    }

    public static String getUserName(){
        Object value = get(CodeConstaint.CONTEXT_KEY_USER_NAME);
        return StringHelper.getObjectValue(value);
    }

    public static String getRegionId(){
        Object value = get(CodeConstaint.CONTEXT_KEY_REGION_ID);
        if (value == null){
            throw new BaseException("regionId 获取不到");
        }
        return StringHelper.getObjectValue(value);
    }

    public static void setUserID(String userID){
        set(CodeConstaint.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setUserName(String username){
        set(CodeConstaint.CONTEXT_KEY_USER_NAME,username);
    }

    public static void setName(String name){set(CodeConstaint.CONTEXT_KEY_USER_NAME,name);}

    public static void setRegionId(String regionId){
        set(CodeConstaint.CONTEXT_KEY_REGION_ID,regionId);
    }

    public static void remove(){
        threadLocal.remove();
    }

}
