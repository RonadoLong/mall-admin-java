package com.shop.common.handler;


import com.shop.common.exception.BaseException;
import com.shop.common.exception.NotFoundException;
import com.shop.common.exception.NotMoreException;
import com.shop.common.exception.auth.AuthException;
import com.shop.common.exception.auth.TokenInvalidException;
import com.shop.common.exception.user.UserException;
import com.shop.common.http.JsonResult;
import com.shop.common.utils.CodeConstaint;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private JsonResult handleException(RuntimeException ex){
        System.out.printf(ex.getLocalizedMessage());
        log.error("【RuntimeException 异常】{}", ex.getMessage());
        return JsonResult.createError("操作失败", CodeConstaint.SYS_ERROR);
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handleBaseException(BaseException ex){
        log.error("【Busy 异常】{}", ex.getMessage());
        return JsonResult.createError(ex.getMessage(), CodeConstaint.SYS_ERROR);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonResult handleNotFountException(NotFoundException ex){
        log.error("【NotFoundException 异常】{}", ex.getMessage());
        return JsonResult.createError(ex.getMessage(), CodeConstaint.NOT_FOUNT);
    }


    @ExceptionHandler(value = NotMoreException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public JsonResult handleNotMoretException(NotMoreException ex){
        log.error("【NotMoreException 没有更多数据】{}", ex.getMessage());
        return JsonResult.createSuccess(ex.getMessage(), CodeConstaint.NOT_MORE);
    }

    @ExceptionHandler(value = UserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult userExceptionHandle(UserException userException){

        log.error("【用户中心请求报错】====== {}", userException.getMessage());
        return JsonResult.createError(userException.getMessage(), userException.getCode());
    }

    @ExceptionHandler(value = TokenInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult exceptionHandle(TokenInvalidException exception){

        log.error("【验证token失败:】===== {}", exception.getMessage());
        return JsonResult.createError(exception.getMessage(), CodeConstaint.TOKEN_ERROR);
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult authExceptionHandle(AuthException ax){

        log.error("【没有权限】===== {}", ax.getMessage());
        return JsonResult.createError(ax.getMessage(), CodeConstaint.TOKEN_ERROR);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult expiredJwtException(ExpiredJwtException ax){

        log.error("【过期】===== {}", ax.getMessage());
        log.error("【过期】===== {}", ax.getHeader());
        log.error("【过期】===== {}", ax.getClaims());
        return JsonResult.createError("token expire", CodeConstaint.TOKEN_ERROR);
    }
}
