package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.CmsCategory;

public interface CmsCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int insert(CmsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int insertSelective(CmsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    CmsCategory selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int updateByPrimaryKeySelective(CmsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_category
     *
     * @mbg.generated Tue Nov 12 16:39:53 CST 2019
     */
    int updateByPrimaryKey(CmsCategory record);
}