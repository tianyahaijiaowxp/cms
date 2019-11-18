package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.CmsRolePrivilege;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:18
 **/
public interface ICmsPrivilegeService {

    public void setPrivilege(Long roleId, Long privilegeId);
}
