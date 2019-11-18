package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.extend.CmsUserExtend;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 15:16
 **/
public interface CmsUserExtendMapper {

    CmsUser selectByUserName(String userName);

    CmsUserExtend selectAllRoleByUserId(Long id);

    CmsUserExtend selectById(Long id);
}
