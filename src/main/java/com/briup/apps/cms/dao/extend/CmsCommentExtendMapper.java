package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsComment;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 16:57
 **/
public interface CmsCommentExtendMapper {

    /**
     * 根据外键article_id查询评论
     * @param articleId
     * @return
     */
    List<CmsComment> selectByArticleId(Long articleId);

    /**
     * 根据外键user_id查询该用户所有发表的评论
     * @param userId
     * @return
     */
    List<CmsComment> selectByUserId(Long userId);

    void deleteByPrimaryKey(Long id);
}
