package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.condition.ArticleCondition;
import com.briup.apps.cms.bean.extend.CmsArticleExtend;
import com.briup.apps.cms.exception.CmsException;
import com.briup.apps.cms.service.ICmsArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 17:12
 **/
@Api(
        description = "文章管理相关接口"
)
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ICmsArticleService articleService;

    @GetMapping("/findAll")
    @ApiOperation("级联查询所有文章")
    public Message findAll(){
        List<CmsArticleExtend> all = articleService.findAll();
        return MessageUtil.success(all);
    }

    @GetMapping("/findAllSimple")
    @ApiOperation("查询所有文章,非级联方式，只含文章基本信息")
    public Message findAllSimple(){
        List<CmsArticleWithBLOBs> allSimple = articleService.findAllSimple();
        return MessageUtil.success(allSimple);
    }

    @GetMapping("/findById")
    @ApiOperation("根据文章Id查询文章的详细信息，包括评论")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query")
    )
    public Message findById(Long id){
        CmsArticleExtend articleExtend = articleService.findByPrimaryKey(id);
        return MessageUtil.success(articleExtend);
    }

    @GetMapping("/findByStatus")
    @ApiOperation("根据文章状态查询文章，status有3个值，1(审核未通过),2(审核通过),3(未审核)")
    public Message findByStatus(String status){
        if(status == null || "".equals(status)){
            throw new CmsException("status不能为空");
        }else{
            List<CmsArticle> articles = articleService.findArticleByStatus(status);
            return MessageUtil.success(articles);
        }
    }

//    @PostMapping("/saveOrUpdate")
//    @ApiOperation("查询或更新文章")
//    public Message saveOrUpdate(CmsArticleWithBLOBs article){
//        articleService.saveOrUpdate(article);
//        return MessageUtil.success("更新成功");
//    }

    @GetMapping("/finArticleByUserId")
    @ApiOperation("查询该用户发布的所有文章")
    public Message findArticleByUserId(Long userId){
        List<CmsArticleExtend> allArticles = articleService.findAllArticleByUserId(userId);
        return MessageUtil.success(allArticles);
    }


    @PostMapping("/saveOrUpdate")
    @ApiOperation("查询或更新文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "form", required = false),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "form", required = true),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "form", required = true),
            @ApiImplicitParam(name = "source", value = "源内容", paramType = "form", required = false),
            @ApiImplicitParam(name = "categoryId", value = "栏目标题", paramType = "form", required = true),
            @ApiImplicitParam(name = "authorId", value = "作者名字", paramType = "form", required = false)
    })
    public Message saveOrUpdate(Long id,
                                @NotNull String title,
                                @NotNull String content,
                                String source,
                                @NotNull Long categoryId,
                                Long authorId){
        CmsArticleWithBLOBs article = new CmsArticleWithBLOBs();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }

    @PostMapping("/findArticleCondition")
    @ApiOperation("根据传入条件查询文章")
    public Message findArticleCondition(ArticleCondition articleCondition){
        if(articleCondition == null){
            throw new CmsException("请输入正确的查询条件查询条件");
        }
        List<CmsArticleExtend> articles = articleService.findArticleByCondition(articleCondition);
        return MessageUtil.success(articles);
    }

    @ApiOperation("根据栏目Id查询文章")
    @GetMapping("/findByCategoryId")
    public Message findByCategoryId(Long categoryId){
        List<CmsArticleExtend> byCategoryId = articleService.findByCategoryId(categoryId);
        return MessageUtil.success(byCategoryId);
    }

    @ApiOperation("根据主键删除文章")
    @GetMapping("/deleteById")
    public Message deleteById(Long id){
        articleService.deleteArticleById(id);
        return MessageUtil.success("删除成功");
    }
}
