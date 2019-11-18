package com.briup.apps.cms.bean.condition;

import lombok.Data;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-13 10:46
 **/
@Data
public class ArticleCondition {
    private String status;

    private String title;

    private Long authorId;

    private Long categoryId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
