package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.condition.ArticleCondition;
import com.briup.apps.cms.bean.extend.CmsArticleExtend;
import com.briup.apps.cms.constant.ArticleStatus;
import com.briup.apps.cms.dao.CmsArticleMapper;
import com.briup.apps.cms.dao.extend.CmsArticleExtendMapper;
import com.briup.apps.cms.exception.CmsException;
import com.briup.apps.cms.service.ICmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: cms
 * @description 文章业务的具体实现类
 * @author: tianya
 * @create: 2019-11-11 17:20
 **/
@Service
public class CmsArticleServiceImpl implements ICmsArticleService {

    @Autowired
    CmsArticleExtendMapper articleExtendMapper;

    @Autowired
    CmsArticleMapper articleMapper;

    @Override
    public List<CmsArticleExtend> findAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public List<CmsArticleWithBLOBs> findAllSimple() {
        return articleExtendMapper.selectAllSimple();
    }

    @Override
    public CmsArticleExtend findByPrimaryKey(Long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(CmsArticleWithBLOBs article) {
        if(article.getId() != null){
            if(!judgeTitleExist(article, article.getTitle())){
                throw new CmsException("标题不能重复");
            }
            articleMapper.updateByPrimaryKeySelective(article);
        }else{
//            标题不能重名
            if(!judgeTitleExist(article, article.getTitle())){
                throw new CmsException("标题不能重复");
            }
            if(article.getTitle() == null || "".equals(article.getTitle())){
                throw new CmsException("标题不能为空");
            }
            if(article.getContent() == null || "".equals(article.getContent())){
                throw new CmsException("内容不能为空");
            }
            // 初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleStatus.STATUS_UNCHECK);
            article.setThumpDown(0L);
            article.setThumpUp(0L);
            articleMapper.insert(article);
        }
    }

    /**
     * 根据文章状态查询已审核（未审核）文章，
     * （管理员用户可查询全部，普通用户只能查询自己部分（未写）
     * @param status
     * @return
     */
    @Override
    public List<CmsArticle> findArticleByStatus(String status) {
        return articleExtendMapper.selectByArticleStatus(status);
    }

    /**
     * 查询该用户发布的所有文章
     * @param userId
     * @return
     */
    @Override
    public List<CmsArticleExtend> findAllArticleByUserId(Long userId) {
        return articleExtendMapper.selectAllArticleByAuthorId(userId);
    }

    @Override
    public List<CmsArticleExtend> findArticleByCondition(ArticleCondition articleCondition) {
        return articleExtendMapper.selectArticleByCondition(articleCondition);
    }

    /**
     * 根据外键category_id查询文章
     * @param categoryId
     * @return
     */
    @Override
    public List<CmsArticleExtend> findByCategoryId(Long categoryId) {
        return articleExtendMapper.selectAllArticleByCategoryId(categoryId);
    }

    /**
     * 根据主键删除文章（将状态设置为'不可见'）
     * @param id
     */
    @Override
    public void deleteArticleById(Long id) {
        articleExtendMapper.deleteArticleByPrimaryKey(id);
    }


    private boolean judgeTitleExist(CmsArticleWithBLOBs article, String title){
        List<CmsArticleWithBLOBs> articleWithBLOBs = articleExtendMapper.selectByTitle(article.getTitle());
        System.out.println(articleWithBLOBs);
        System.out.println("----" + article.getTitle() + "-----");
        if(articleWithBLOBs.size() > 0){
            return false;
        }else{
            return true;
        }
    }
}
