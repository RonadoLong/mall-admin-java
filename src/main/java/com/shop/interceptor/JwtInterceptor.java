package com.shop.interceptor;

import com.shop.common.exception.BaseException;
import com.shop.common.exception.auth.AuthException;
import com.shop.common.exception.auth.TokenInvalidException;
import com.shop.common.utils.JWTInfo;
import com.shop.common.utils.jwt.JwtTokenService;
import com.shop.context.BaseContextHandler;
import com.shop.dao.AdminUserDao;
import com.shop.entity.AdminUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AdminUserDao adminUserDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader(jwtTokenService.getHeader());

        if (StringUtils.isEmpty(token)){
            throw new TokenInvalidException("token null");
        }

        logger.info(httpServletRequest.getRequestURI());

        JWTInfo info = jwtTokenService.getInfoFromToken(token);

        if (StringUtils.isEmpty(info.getUserId())){
           throw new BaseException("没有该权限!");
        }

        Integer userId =  Integer.parseInt(info.getUserId());
        AdminUser adminUser = adminUserDao.selectByPrimaryKey(userId);
        if (adminUser == null){
            throw new AuthException("该用户不存在!");
        }

        logger.info("login user = " + userId);
        BaseContextHandler.setName(info.getUserName());
        BaseContextHandler.setUserID(info.getUserId());

        String url = httpServletRequest.getRequestURI();
//        if(!userHasPrivilege(userId, url)){
//            throw new AuthException("没有该权限!");
//        }
//        saveLog( httpServletRequest);

        return super.preHandle(httpServletRequest, httpServletResponse, o);
    }



}
