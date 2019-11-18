package com.briup.apps.cms.utils;

import com.briup.apps.cms.constant.ResponseStatus;

import java.util.Date;

public class MessageUtil {
    /**
     * 返回失败消息，一般用于增删改操作的结果返回
     * */
    public static Message error(String msg){
        Message message = new Message();
        message.setStatus(ResponseStatus.ERROR);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功消息，一般用于增删改操作的结果返回
     * */
    public static Message success(String msg){
        return success("success", null);
    }
    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static <T> Message success(String msg,T data){
        Message message = new Message();
        message.setStatus(ResponseStatus.OK);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static <T> Message success(T data){
        return success("success", data);
    }

}
