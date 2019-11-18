package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.*;
import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description CmsUser的扩展类
 * @author: tianya
 * @create: 2019-11-12 19:38
 **/
@Data
public class CmsUserExtend extends CmsUser {
    private List<CmsUserRole> userRoles;

    private List<CmsComment> comments;

    private List<CmsArticleExtend>  articleExtends;

    private List<CmsLogs> logs;

    private List<CmsUserRoleExtend> userRoleExtends;

    private List<CmsRole> roles;

    private List<CmsPrivilege> privileges;
}
