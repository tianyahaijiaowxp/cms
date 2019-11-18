package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.extend.CmsRoleExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-15 09:54
 **/
public interface CmsRoleExtendMapper {
    CmsRoleExtend selectUserByRoleId(Long id);

    List<CmsRole> selectByUserId(Long id);

    CmsRole selectRoleByName(String name);
}
