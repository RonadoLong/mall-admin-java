package com.shop.upload.controller;

import com.alibaba.fastjson.JSONObject;

import com.shop.common.exception.BaseException;
import com.shop.common.http.JsonResult;
import com.shop.upload.QiniuUploadVo;
import com.shop.upload.service.QiniuTokenService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/resource")
public class QiniuTokenRest {

    @Autowired
    private QiniuTokenService qiniuTokenService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/image/token", method = RequestMethod.GET)
    public JsonResult uploadAvatarImage(){
        JSONObject jsonObject = qiniuTokenService.generateToken();
        return JsonResult.createSuccess(jsonObject);
    }

    @PostMapping(value = "/uploadImage")
    private JsonResult uploadImage(@RequestBody MultipartFile file){
        try {
            byte[] imgArr = file.getBytes();
            String imgPath = qiniuTokenService.uploadImg(imgArr);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("file", imgPath);
            return JsonResult.createSuccess(jsonObject);
        } catch (IOException e) {
            throw new BaseException("图片参数获取不到");
        }
    }

    @PostMapping("video/token")
    public  JsonResult uploadVideo(@RequestBody QiniuUploadVo qiniuUploadVo){
        if (qiniuUploadVo == null){
            return JsonResult.createParamError();
        }
        String token = qiniuTokenService.generateTokenByVideo(qiniuUploadVo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        return JsonResult.createSuccess(jsonObject);
    }

}
