package com.briup.apps.cms.vm;

import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-17 23:17
 **/
@Data
public class PrivilegeVM {
    private Long roleId;
    private List<Long> privilegeIds;
}
