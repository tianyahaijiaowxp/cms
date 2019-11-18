package com.briup.apps.cms.web.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(
        description = "这是测试相关接口"
)
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/findAll")
    public List<Map<String, String>> findAll(){
        Map<String, String> map = new HashMap<>();
        map.put("one", "hello");
        map.put("two", "world");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        return list;
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(){

        return "保存成功";
    }

    @Autowired
    private StringRedisTemplate strTplRedis;
    @GetMapping("/testredis")
    public String testRedis(){
        String s = strTplRedis.opsForValue().get("a");
        return s;
    }
}
