package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.CmsArticleWithBLOBs;
import com.briup.apps.cms.bean.CmsCategory;
import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-14 09:10
 **/
@Data
public class CmsCategoryExtend extends CmsCategory {

    private List<CmsArticleExtend> articleExtends;

    /**
     * 所有子栏目
     */
    private List<CmsCategory> categories;


    private CmsCategory category;
}
