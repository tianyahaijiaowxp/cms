package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.CmsCategory;
import com.briup.apps.cms.bean.extend.CmsCategoryExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:17
 **/
public interface ICmsCategoryService {

    /**
     * 级联查询所有栏目
     * @return
     */
    public List<CmsCategoryExtend> findAll();

    public void saveOrUpdate(CmsCategory category);

    public void deleteById(Long id);

    public void batchDelete(Long[] ids);
}
