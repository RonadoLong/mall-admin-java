package com.shop.common.http;


import com.shop.common.enums.ResultEnum;

import java.io.Serializable;

public class JsonResult implements Serializable{

    private int code;
    private String message;
    private Object data;

    public JsonResult(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int code, Object data) {
        this.code = code;
        this.message = ResultEnum.SUCCESS.getMessage();
        this.data = data;
    }


    public JsonResult(Object data) {
        this.data = data;
    }



    public static JsonResult createSuccess(Object data){
        JsonResult jsonResult = new JsonResult(ResultEnum.SUCCESS.getCode(), data);
        return  jsonResult;
    }

    public static JsonResult createSuccess(){
        JsonResult jsonResult = new JsonResult(ResultEnum.SUCCESS.getCode(), null);
        return  jsonResult;
    }

    public static JsonResult createSuccess(String message){
        return  new JsonResult(ResultEnum.SUCCESS.getCode(), message,null);
    }

    public static JsonResult createSuccess(String message, Object data){
        JsonResult jsonResult = new JsonResult(data);
        jsonResult.setCode(ResultEnum.SUCCESS.getCode());
        jsonResult.setMessage(message);
        jsonResult.setData(data);
        return  jsonResult;
    }

    public static JsonResult createError(String message){
        JsonResult jsonResult = new JsonResult(ResultEnum.FAIL.getCode(), message,null);
        return  jsonResult;
    }

    public static JsonResult createError(String message, int code){
        JsonResult jsonResult = new JsonResult(code, message,null);
        return  jsonResult;
    }

    public static JsonResult createError(String message ,Object data){

        JsonResult jsonResult = new JsonResult(ResultEnum.LOGINFAIL.getCode(), data);
        jsonResult.setCode(ResultEnum.FAIL.getCode());
        jsonResult.setMessage(message);
        jsonResult.setData(data);
        return  jsonResult;
    }

    public static JsonResult createParamError(){
        return new JsonResult(ResultEnum.PARAMS_ERROR.getCode(),
                ResultEnum.PARAMS_ERROR.getMessage(),
                null);
    }

    public static JsonResult createNoContent(){
        return new JsonResult(ResultEnum.NOT_ANY_MORE.getCode(), ResultEnum.NOT_ANY_MORE.getMessage(),null);
    }

}
