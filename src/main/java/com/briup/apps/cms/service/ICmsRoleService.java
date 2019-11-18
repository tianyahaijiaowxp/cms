package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.extend.CmsRoleExtend;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:19
 **/
public interface ICmsRoleService {
    /**
     * 级联查询，将user绑定在CmsUserRole中，使其蕴含user信息
     * @param id
     * @return
     */
    public CmsRoleExtend findAllUserByRoleId(Long id);

    /**
     * 创建一个新角色
     * @param role
     */
    public void createRole(CmsRole role);
}
