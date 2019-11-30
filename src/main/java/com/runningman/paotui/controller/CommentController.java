package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.Comment;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.AuthService;
import com.runningman.paotui.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.controller
 * @versio: 1.0
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "makeComment",method = RequestMethod.POST)
    public Result makeComment(int start ,int id, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result().fail("nologin","未登录",0);
        }

        Comment comment1 = commentService.qurryCommentByOrder_Id(id);
        if(comment1==null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = null;
            try {
                time = dateFormat.parse(dateFormat.format(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Comment comment = new Comment();
            comment.setOrderId(id);
            comment.setStart(start);
            comment.setTime(time);
            comment.setUser(user.getUsername());
            comment.setInfo("评分"+comment.getStart());
            commentService.insertComment(comment);
            authService.changeAuthStart(comment.getUser(),comment.getStart());
            return new Result().success("评价成功",0,"ok");
        }
        return new Result().fail("cantComment","您已经为该订单评过分",0);
    }
}
