package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.service.ICmsPrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.PrivilegeVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-17 22:33
 **/

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private ICmsPrivilegeService privilegeService;

    @PostMapping("/setPrivilege")
    public Message setPrivilege(@RequestBody PrivilegeVM privilegeVM){
        List<Long> privilegeIds = privilegeVM.getPrivilegeIds();
        for (Long privilegeId : privilegeIds) {
            privilegeService.setPrivilege(privilegeVM.getRoleId(), privilegeId);
        }
        return MessageUtil.success("授权成功");
    }
}
