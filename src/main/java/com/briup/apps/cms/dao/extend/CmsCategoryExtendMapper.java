package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsCategory;
import com.briup.apps.cms.bean.extend.CmsCategoryExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-14 09:14
 **/
public interface CmsCategoryExtendMapper {

    List<CmsCategoryExtend> selectAll();

    List<CmsCategory> selectByParentId(Long parentId);

    CmsCategory selectByName(String name);
}
