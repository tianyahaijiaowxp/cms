package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.CmsComment;

public interface CmsCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int insert(CmsComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int insertSelective(CmsComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    CmsComment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int updateByPrimaryKeySelective(CmsComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(CmsComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int updateByPrimaryKey(CmsComment record);
}