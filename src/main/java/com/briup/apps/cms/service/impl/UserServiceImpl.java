package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.extend.CmsUserExtend;
import com.briup.apps.cms.bean.extend.CmsUserRoleExtend;
import com.briup.apps.cms.dao.CmsUserMapper;
import com.briup.apps.cms.dao.extend.CmsUserExtendMapper;
import com.briup.apps.cms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-11 12:27
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private CmsUserExtendMapper userExtendMapper;
    @Autowired
    private CmsUserMapper userMapper;

    /**
     * 根据用户名查找数据库
     * @param userName
     * @return
     */
    public CmsUser findUserByUserName(String userName){
        return userExtendMapper.selectByUserName(userName);
    }

    /**
     * 级联查询获取用户角色，但是会获取用户密码，因此需要重新将密码设置为空字符串（""）
     * @param id
     * @return
     */
    @Override
    public CmsUserExtend findAllRoleById(Long id) {
        CmsUserExtend userExtend = userExtendMapper.selectAllRoleByUserId(id);
        List<CmsUserRoleExtend> userRoleExtends = userExtend.getUserRoleExtends();
        for (CmsUserRoleExtend userRoleExtend : userRoleExtends) {
            CmsUser user = userRoleExtend.getUser();
            user.setPassword("");
        }
        return userExtend;
    }

    /**
     * 根据用户id查询用户基本信息，包括用户角色
     * @param id
     * @return
     */
    @Override
    public CmsUserExtend findUserById(Long id) {
        return userExtendMapper.selectById(id);
    }
}
