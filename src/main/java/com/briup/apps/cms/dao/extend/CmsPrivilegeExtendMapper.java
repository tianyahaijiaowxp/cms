package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsPrivilege;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-17 15:59
 **/
public interface CmsPrivilegeExtendMapper {

    List<CmsPrivilege> selectByUserId(Long id);
}
