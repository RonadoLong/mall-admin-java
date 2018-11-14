package com.shop.controller;

import com.alibaba.fastjson.JSONObject;

import com.shop.common.enums.ResultEnum;
import com.shop.common.exception.BaseException;
import com.shop.common.exception.NotFoundException;
import com.shop.common.http.JsonResult;
import com.shop.common.utils.JWTInfo;
import com.shop.common.utils.MD5Util;
import com.shop.common.utils.jwt.JwtTokenService;
import com.shop.entity.AdminUser;
import com.shop.service.AdminUserService;
import com.shop.vo.AdminUserVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
@Slf4j
@Api(tags = "用户登录相关")
public class AdminLoginRest {

    @Autowired
    private JwtTokenService jwtTokenUtil;

    @Autowired
    private AdminUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult getLogin(@RequestBody AdminUserVo userVo){

        if (StringUtils.isEmpty(userVo.getPassword())
                || StringUtils.isEmpty(userVo.getUsername())){
            return JsonResult.createParamError();
        }

        JWTInfo tokenInfo = new JWTInfo();
        String password = MD5Util.encryptWithStal(userVo.getPassword());

        System.out.println( password);

        AdminUser adminUser = userService.findByNameAndPassword(userVo.getUsername(), password);
        if (adminUser == null){
            throw new NotFoundException("用户不存在");
        }

        tokenInfo.setUserId(String.valueOf(adminUser.getId()));
        tokenInfo.setUserName(adminUser.getUsername());

        JWTInfo jwtInfo = new JWTInfo(tokenInfo.getUserName(),
                tokenInfo.getUserId(),
                tokenInfo.getRegionId());
        try {
            String token = jwtTokenUtil.generateToken(jwtInfo);
            tokenInfo.setToken(token);
            tokenInfo.setUserId(null);
            JSONObject json = new JSONObject();
            json.put("token", token);
            json.put("username", tokenInfo.getUserName());
            return JsonResult.createSuccess(ResultEnum.SUCCESS.getMessage(), json);

        } catch (Exception e) {
            throw new BaseException("生成token失败");
        }

    }
}
