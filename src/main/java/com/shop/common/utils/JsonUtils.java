package com.shop.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtils {

    /**
     * 获取漂亮格式json
     * @param object
     * @return
     */
    public static String getPrettyString(Object object){
        return JSONObject.toJSONString(object, true);
    }


    public static JSONObject getJsonByList(List obts, String jsonKey){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(obts);
        jsonObject.put(jsonKey, jsonArray);
        return jsonObject;
    }

    public static JSONObject getJson(Object obj){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        return jsonObject;
    }

}
