package com.briup.apps.cms.web.controller;

import com.alibaba.fastjson.JSON;
import com.briup.apps.cms.bean.CmsUser;
import com.briup.apps.cms.bean.extend.CmsUserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-13 09:16
 **/
@Api(
        description = "用户管理相关接口"
)
@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StringRedisTemplate strTplRedis;
    @Autowired
    private IUserService userService;

    @ApiOperation("根据用户名查询用户信息，可用于登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value="用户名",paramType = "query",required = true),
            @ApiImplicitParam(name="password",value="密码",paramType = "query",required = true)
    })
    @PostMapping("/findByName")
    public Message findUserByName(String userName, String password){
        String token = generateToken();
        System.out.println(token);
        CmsUser user = userService.findUserByUserName(userName);
        String message = "";
        if(user != null && user.getPassword().equals(password)){
            user.setPassword("");
            message = JSON.toJSONString(user);
            strTplRedis.opsForValue().set(token,message,15 * 24 * 60 * 60, TimeUnit.SECONDS);
            return MessageUtil.success("success",token);
        }else{
            return MessageUtil.error("用户名或密码错误，请重新输入!");
        }
    }

    @ApiOperation("根据token换取用户信息")
    @ApiImplicitParam(name="token",value="token",paramType = "query",required = true)
    @GetMapping("/getUserInfo")
    public Message getUserInfo(String token){
        String info = strTplRedis.opsForValue().get(token);
        if("".equals(info)){
            return MessageUtil.error("登录信息已过期");
        }else{
            return MessageUtil.success("success", info);
        }
    }

    @ApiOperation("根据用户Id查询该用户拥有的所有角色")
    @ApiImplicitParam(name = "id",value = "主键（用户id）", paramType = "query",required = true)
    @GetMapping("/findAllRole")
    public Message findAllRole(Long id){
        CmsUserExtend allRoleById = userService.findAllRoleById(id);
        return MessageUtil.success(allRoleById);
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Message login(@RequestBody UserVM userVM){
        //1.认证用户的用户名和密码
        //2.如果登录成功产生token，将token缓存起来，返回
        //3.如果登录失败
        Map<String,String> map = new HashMap<String,String>();
        String token = generateToken();
        map.put("token",token);
        return MessageUtil.success(map);
    }

    @ApiOperation("通过token获取用户的基本信息")
    @GetMapping("/info")
    public Message info(String token){
        //1.通过token获取用户信息
        CmsUserExtend userWithRole = userService.findUserById(1L);
        //2.
        return MessageUtil.success(userWithRole);
    }

    @PostMapping("/logout")
    public Message logout(){
        //1.退出时将token从Redis从移除
        return MessageUtil.success("退出成功");
    }


    private String generateToken(){
        return String.valueOf(UUID.randomUUID());
    }
}
