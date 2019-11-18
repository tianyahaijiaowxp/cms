package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.CmsUserRoleExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-14 09:51
 **/
public interface CmsUserRoleExtendMapper {
    /**
     * 根据用户Id查询该用户的所有角色
     * @param userId
     * @return
     */
    List<CmsUserRoleExtend> selectByUserId(Long userId);

    /**
     * 根据角色Id查询所有该角色的用户
     * @param roleId
     * @return
     */
    List<CmsUserRoleExtend> selectByRoleId(Long roleId);
}
