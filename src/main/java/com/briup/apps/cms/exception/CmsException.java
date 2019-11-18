package com.briup.apps.cms.exception;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 19:22
 **/
public class CmsException extends RuntimeException {
    public CmsException() {
        super();
    }

    public CmsException(String message) {
        super(message);
    }

    public CmsException(String message, Throwable cause) {
        super(message, cause);
    }
}
