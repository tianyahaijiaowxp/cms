package com.briup.apps.cms.utils;

import lombok.Data;

@Data
public class Message<T> {
    private Integer status; //状态码 200 500
    private String message; //信息
    private T data;    //操作结果，查询结构
    private Long timestamp; //时间戳
}
