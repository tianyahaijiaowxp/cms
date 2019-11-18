package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.CmsRolePrivilege;
import com.briup.apps.cms.dao.CmsRolePrivilegeMapper;
import com.briup.apps.cms.service.ICmsPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:23
 **/
@Service
public class CmsPrivilegeServiceImpl implements ICmsPrivilegeService {
    @Autowired
    private CmsRolePrivilegeMapper rolePrivilegeMapper;
    @Override
    public void setPrivilege(Long roleId, Long privilegeId) {
        CmsRolePrivilege rolePrivilege = new CmsRolePrivilege();
        rolePrivilege.setRoleId(roleId);
        rolePrivilege.setPrivilegeId(privilegeId);
        rolePrivilegeMapper.insert(rolePrivilege);
    }
}
