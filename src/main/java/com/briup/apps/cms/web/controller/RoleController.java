package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.CmsRole;
import com.briup.apps.cms.bean.extend.CmsRoleExtend;
import com.briup.apps.cms.service.ICmsRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-15 10:04
 **/

@Api(
        description = "角色管理相关接口"
)
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private ICmsRoleService roleService;

    @ApiOperation("根据id查询用户信息")
    @ApiImplicitParam(name = "id",value = "主键（用户id）", paramType = "query", required = true)
    @GetMapping("/findAllUser")
    public Message findAllUser(Long id){
        CmsRoleExtend allUserByRoleId = roleService.findAllUserByRoleId(id);
        return MessageUtil.success(allUserByRoleId);
    }

    @ApiOperation("创建一个新的角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "角色名", paramType = "query", required = true)
    })
    @PostMapping("/createRole")
    public Message createRole(CmsRole role){
        roleService.createRole(role);
        return MessageUtil.success("创建角色成功");
    }
}
