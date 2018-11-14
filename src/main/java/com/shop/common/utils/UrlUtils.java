package com.shop.common.utils;


import com.shop.common.enums.SourceTypeEnum;

public class UrlUtils {

    public static String getSourceUrl(Integer Id, SourceTypeEnum sourceType){
        if(Id == null || Id == 0 || sourceType == null){
            return "";
        }
        switch (sourceType){
            case LIVE:
                return "live/detail/" + Id.toString();
            case VIDEO:
                return "video/detail/" + Id.toString();
            case NEWS:
                return "news/detail/" + Id.toString();
            case WECHAT:
                return "wechat/article/detail/" + Id.toString();
            case COMMUNITY_POST:
                return "community/post/detail/" + Id.toString();
            case COMMUNITY:
                return "community/type/" + Id.toString();
            default:
                return "";

        }

    }
}
