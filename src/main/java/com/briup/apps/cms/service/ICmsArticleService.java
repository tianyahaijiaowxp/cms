package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.condition.ArticleCondition;
import com.briup.apps.cms.bean.extend.CmsArticleExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 17:16
 **/
public interface ICmsArticleService {
    /**
     * 级联查询所有文章
     * @return
     */
    public List<CmsArticleExtend> findAll();

    public List<CmsArticleWithBLOBs> findAllSimple();

    public CmsArticleExtend findByPrimaryKey(Long id);

    public void saveOrUpdate(CmsArticleWithBLOBs article);

    /**
     * 根据文章状态查询已审核（未审核）文章，
     * （管理员用户可查询全部，普通用户只能查询自己部分（未写）
     * @param status
     * @return
     */
    public List<CmsArticle> findArticleByStatus(String status);

    /**
     * 根据外界user_id查询所有该用户的文章
     * @param userId
     * @return
     */
    public List<CmsArticleExtend> findAllArticleByUserId(Long userId);

    /**
     * 根据传入条件查询获得article
     * @param articleCondition
     * @return
     */
    public List<CmsArticleExtend> findArticleByCondition(ArticleCondition articleCondition);

    /**
     * 根据外键 category_id查询文章
     * @param categoryId
     * @return
     */
    public List<CmsArticleExtend> findByCategoryId(Long categoryId);

    /**
     * 根据id删除文章
     * @param id
     */
    public void deleteArticleById(Long id);
}
