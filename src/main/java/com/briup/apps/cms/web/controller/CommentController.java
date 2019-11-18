package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.service.ICmsCommentService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-14 10:15
 **/
@Api(
        description = "评论管理相关接口"
)
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICmsCommentService commentService;

    @GetMapping("/deleteComment")
    @ApiOperation("根据评论id删除评论")
    public Message deleteCommentById(Long id){
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
