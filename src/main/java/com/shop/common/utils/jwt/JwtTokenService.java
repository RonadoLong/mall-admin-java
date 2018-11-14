package com.shop.common.utils.jwt;



import com.shop.common.utils.JWTHelper;
import com.shop.common.utils.JWTInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ace on 2017/9/10.
 */
@Service
@ConfigurationProperties
public class JwtTokenService {

    private int expire = 72000;

    private String priKeyPath = "auth/pri.key";

    private String pubKeyPath = "auth/pub.key";

    private String header;

    public String generateToken(JWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo,priKeyPath,expire);
    }

    public JWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token,pubKeyPath);
    }

    public String getHeader() {
        return "Authorization";
    }



    public int getExpire() {
        return expire;
    }


    public String getPriKeyPath() {
        return priKeyPath;
    }


    public String getPubKeyPath() {
        return pubKeyPath;
    }

}
