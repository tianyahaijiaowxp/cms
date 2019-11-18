package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.dao.extend.CmsCommentExtendMapper;
import com.briup.apps.cms.service.ICmsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:21
 **/
@Service
public class CmsCommentServiceImpl implements ICmsCommentService {
    @Autowired
    private CmsCommentExtendMapper commentExtendMapper;

    @Override
    public void deleteById(Long id) {
        commentExtendMapper.deleteByPrimaryKey(id);
    }
}
