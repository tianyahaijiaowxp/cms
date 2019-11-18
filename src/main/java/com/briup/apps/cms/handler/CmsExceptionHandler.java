package com.briup.apps.cms.handler;

import com.briup.apps.cms.exception.CmsException;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-14 18:56
 **/
@RestControllerAdvice
public class CmsExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public <E>Message handler(Exception e){
        e.printStackTrace();
        if(e instanceof CmsException){
            return MessageUtil.error(e.getMessage());
        }
        return MessageUtil.error("后台接口异常!");
    }
}
