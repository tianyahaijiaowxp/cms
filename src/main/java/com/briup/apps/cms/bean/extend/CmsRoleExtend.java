package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.CmsPrivilege;
import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.CmsRolePrivilege;
import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-15 09:54
 **/
@Data
public class CmsRoleExtend extends CmsRole {

    private List<CmsUserRoleExtend> userRoleExtends;

    private List<CmsRolePrivilege> rolePrivileges;

    private List<CmsPrivilege> privileges;
}
