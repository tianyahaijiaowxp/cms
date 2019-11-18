package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.CmsArticle;
import com.briup.apps.cms.bean.CmsComment;
import com.briup.apps.cms.bean.CmsUser;
import lombok.Data;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-12 16:54
 **/
@Data
public class CmsCommentExtend extends CmsComment {
    private CmsUser user;

    private CmsArticle article;
}
