package com.shop.common.utils;

import java.io.Serializable;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTInfo implements Serializable{

    private String userName;
    private String userId;
    private String regionId;
    private String isFrom;
    private String token;

    public JWTInfo(){

    }

    public JWTInfo(String username, String userId, String regionId) {
        this.userName = username;
        this.userId = userId;
        this.regionId = regionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getIsFrom() {
        return isFrom;
    }

    public void setIsFrom(String isFrom) {
        this.isFrom = isFrom;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWTInfo jwtInfo = (JWTInfo) o;

        if (userName != null ? !userName.equals(jwtInfo.userName) : jwtInfo.userName != null) return false;
        if (userId != null ? !userId.equals(jwtInfo.userId) : jwtInfo.userId != null) return false;
        if (regionId != null ? !regionId.equals(jwtInfo.regionId) : jwtInfo.regionId != null) return false;
        if (isFrom != null ? !isFrom.equals(jwtInfo.isFrom) : jwtInfo.isFrom != null) return false;
        return token != null ? token.equals(jwtInfo.token) : jwtInfo.token == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (isFrom != null ? isFrom.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
