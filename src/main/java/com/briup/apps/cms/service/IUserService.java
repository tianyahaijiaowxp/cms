package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.extend.CmsUserExtend;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 12:26
 **/
public interface IUserService {

    public CmsUser findUserByUserName(String userName);

    public CmsUserExtend findAllRoleById(Long id);

    public CmsUserExtend findUserById(Long id);
}
