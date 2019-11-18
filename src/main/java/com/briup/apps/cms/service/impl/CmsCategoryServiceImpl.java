package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.CmsCategory;
import com.briup.apps.cms.bean.extend.CmsCategoryExtend;
import com.briup.apps.cms.dao.CmsCategoryMapper;
import com.briup.apps.cms.dao.extend.CmsCategoryExtendMapper;
import com.briup.apps.cms.exception.CmsException;
import com.briup.apps.cms.service.ICmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:21
 **/
@Service
public class CmsCategoryServiceImpl implements ICmsCategoryService {
    @Autowired
    private CmsCategoryExtendMapper categoryExtendMapper;
    @Autowired
    public CmsCategoryMapper categoryMapper;
    @Override
    public List<CmsCategoryExtend> findAll() {
        return categoryExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(CmsCategory category) {
        if(category.getId() != null){
            categoryMapper.updateByPrimaryKey(category);
        }else{
            CmsCategory cmsCategory = categoryExtendMapper.selectByName(category.getName());
            if(cmsCategory != null){
                throw new CmsException("栏目名已存在");
            }else{
                categoryMapper.insert(category);
            }
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        CmsCategory category = categoryMapper.selectByPrimaryKey(id);
        if(category == null){
            throw new CmsException("所删除栏目不存在");
        }else {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public void batchDelete(Long[] ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }
}
