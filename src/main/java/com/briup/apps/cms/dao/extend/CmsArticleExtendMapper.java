package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.condition.ArticleCondition;
import com.briup.apps.cms.bean.extend.CmsArticleExtend;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 17:03
 **/
public interface CmsArticleExtendMapper {
    /**
     * 级联查询所有文章
     * @return
     */
    List<CmsArticleExtend> selectAll();

    /**
     * 查询所有文章（非级联方式）
     * @return
     */
    List<CmsArticleWithBLOBs> selectAllSimple();

    /**
     * 根据主键查询一篇文章的所有信息
     * @param id
     * @return
     */
    CmsArticleExtend selectById(Long id);

    /**
     * 根据标题查询文章（检查标题是否重名）
     * @param title
     * @return
     */
    List<CmsArticleWithBLOBs> selectByTitle(String title);

    /**
     * 根据文章状态（未审核，审核...）查询所有文章
     * @param status
     * @return
     */
    List<CmsArticle> selectByArticleStatus(String status);

    /**
     * 查询该用户发表的全部文章
     * @param authorId
     * @return
     */
    List<CmsArticleExtend> selectAllArticleByAuthorId(Long authorId);

    List<CmsArticleExtend> selectArticleByCondition(ArticleCondition articleCondition);

    List<CmsArticleExtend> selectAllArticleByCategoryId(Long categoryId);

    /**
     * 根据文章id删除文章，实际只是将其状态设置为普通用户不可见
     * @param id
     */
    void deleteArticleByPrimaryKey(Long id);
}
