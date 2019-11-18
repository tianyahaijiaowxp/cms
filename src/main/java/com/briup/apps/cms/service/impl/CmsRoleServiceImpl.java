package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.extend.CmsRoleExtend;
import com.briup.apps.cms.bean.extend.CmsUserRoleExtend;
import com.briup.apps.cms.dao.CmsRoleMapper;
import com.briup.apps.cms.dao.extend.CmsRoleExtendMapper;
import com.briup.apps.cms.exception.CmsException;
import com.briup.apps.cms.service.ICmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:23
 **/
@Service
public class CmsRoleServiceImpl implements ICmsRoleService {
    @Autowired
    private CmsRoleMapper roleMapper;
    @Autowired
    private CmsRoleExtendMapper roleExtendMapper;

    /**
     * 根据角色id查询用户信息，但是需要排除用户密码
     * @param id
     * @return
     */
    @Override
    public CmsRoleExtend findAllUserByRoleId(Long id) {
        CmsRoleExtend cmsRoleExtend = roleExtendMapper.selectUserByRoleId(id);
        List<CmsUserRoleExtend> userRoleExtends = cmsRoleExtend.getUserRoleExtends();
        for (CmsUserRoleExtend userRoleExtend : userRoleExtends) {
            CmsUser user = userRoleExtend.getUser();
            user.setPassword("");
        }
        return cmsRoleExtend;
    }

    /**
     * 创建一个新角色
     * @param role
     */
    @Override
    public void createRole(CmsRole role) {
        CmsRole cmsRole = roleExtendMapper.selectRoleByName(role.getName());
        if(cmsRole != null){
            throw new CmsException("该角色名已存在");
        }else {
            roleMapper.insert(role);
        }
    }
}
