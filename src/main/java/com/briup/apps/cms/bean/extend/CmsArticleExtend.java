package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.CmsCategory;
import com.briup.apps.cms.bean.CmsComment;
import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description Article的扩展类，用于解决其一对多，一对一，多对一的关联查询
 * @author: tianya
 * @create: 2019-11-12 16:41
 **/
@Data
public class CmsArticleExtend extends CmsArticleWithBLOBs {
    private List<CmsComment> comments;

    private CmsCategory category;
}
