package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.CmsUserRole;
import lombok.Data;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 19:42
 **/

@Data
public class CmsUserRoleExtend extends CmsUserRole {
    private CmsUser user;

    private CmsRole role;
}
