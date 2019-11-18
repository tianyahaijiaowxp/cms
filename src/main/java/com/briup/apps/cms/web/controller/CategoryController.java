package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.CmsCategory;
import com.briup.apps.cms.bean.extend.CmsCategoryExtend;
import com.briup.apps.cms.service.ICmsCategoryService;
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
 * @create: 2019-11-14 09:28
 **/
@Api(
        description = "栏目管理相关接口"
)
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICmsCategoryService categoryService;

    @GetMapping("/findAll")
    @ApiOperation("级联查询所有栏目")
    public Message findAll(){
        List<CmsCategoryExtend> all = categoryService.findAll();
        return MessageUtil.success(all);
    }



    @PostMapping("/saveOrUpdate")
    @ApiOperation("保存或更新（传id为更新，不传id为保存）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键",paramType = "form",required = false),
            @ApiImplicitParam(name="name",value="栏目名称",paramType = "form",required = true),
            @ApiImplicitParam(name="description",value="栏目描述",paramType = "form",required = false),
            @ApiImplicitParam(name="no",value="栏目序号",paramType = "form",required = false),
            @ApiImplicitParam(name="parentId",value="父栏目id",paramType = "form",required = false),
    })
    public Message saveOrUpdate(
            Long id,
            @NotNull String name,
            String description,
            Integer no,
            Long parentId
    ){
        CmsCategory category = new CmsCategory();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setNo(no);
        category.setParentId(parentId);
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("更新成功");
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据主键id删除栏目")
    public Message deleteById(Long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除")
    public Message batchDelete(Long[] ids){
        categoryService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }
}
