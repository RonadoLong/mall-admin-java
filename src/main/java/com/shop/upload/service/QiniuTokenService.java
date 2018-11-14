package com.shop.upload.service;


import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import com.shop.common.exception.BaseException;
import com.shop.upload.QiniuConfig;
import com.shop.upload.QiniuUploadVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;


@Service
@Slf4j
public class QiniuTokenService {

    private static final Zone Z = Zone.autoZone();
    private static final UploadManager UPLOAD_MANAGER = new UploadManager(new Configuration(Z));
    private static Auth auth = Auth.create(QiniuConfig.qiniuAK, QiniuConfig.qiniuSK);
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public JSONObject generateToken() {
        try {

            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            String key = String.valueOf("city/share/" + uuid.toLowerCase()) + "." + "png";
            System.out.printf("key  =======  " + key);
            String token = auth.uploadToken(QiniuConfig.bucket, key,3600, new StringMap().putNotEmpty("saveKey",key),true);
            JSONObject jsonObject = new JSONObject();
            System.out.printf(token);
            jsonObject.put("token", token);
            jsonObject.put("key", key);

            return jsonObject;
        }catch (Exception e){
            System.out.printf("error" + e.getMessage());
            return null;
        }
    }

    public String generateTokenByImg() {
        return auth.uploadToken(QiniuConfig.bucket);
    }

    public String uploadImg(byte[] imgBytes) {
        try {
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            String newFileName = String.valueOf("city/share/" + uuid.toLowerCase()) + "." + "png";
            String token = auth.uploadToken(QiniuConfig.bucket, newFileName);
            Response res = UPLOAD_MANAGER.put(imgBytes, newFileName, token);
            if (res.statusCode == 200){
                return newFileName;
            }
            log.error(res.bodyString());
            return null;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BaseException("上传图片失败");
        }
    }

    public String generateTokenByVideo(QiniuUploadVo qiniuUploadVo){
        Auth auth = Auth.create(QiniuConfig.qiniuAK, QiniuConfig.qiniuSK);
        final String fileName = String.format("%s:%s", QiniuConfig.bucket, qiniuUploadVo.getImgName());
        final String fileKey = UrlSafeBase64.encodeToString(fileName);
        final String fops = String.format("vframe/jpg/offset/1/w/%s/h/%s|saveas/%s",qiniuUploadVo.getVideoW(),qiniuUploadVo.getVideoH(),fileKey);
        final StringMap policy = new StringMap();
        policy.putNotEmpty("scope", QiniuConfig.bucket);
        policy.putNotEmpty("persistentOps", fops);
        return auth.uploadToken(QiniuConfig.bucket, null, QiniuConfig.expires, policy);
    }

}
