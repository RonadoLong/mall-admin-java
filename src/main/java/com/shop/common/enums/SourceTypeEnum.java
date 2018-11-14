package com.shop.common.enums;

public enum SourceTypeEnum {

    WECHAT(1),
    NEWS(2),
    COMMUNITY_POST(3),
    VIDEO(4),
    LIVE(5),
    COMMUNITY(6);


    private Integer Id;

    public Integer getId() {
        return Id;
    }

    SourceTypeEnum(Integer Id){
        this.Id = Id;
    }

    public Integer getSourceTypeEnum(){
        return this.Id;
    }


}
