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

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.controller
 * @versio: 1.0
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/makeComment",method = RequestMethod.POST)
    public Result makeComment(Comment comment, HttpSession session) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        comment.setTime(time);
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result().fail("nologin","未登录",0);
        }
        commentService.insertComment(comment);
        authService.changeAuthStart(comment.getUser(),comment.getStart());
        return new Result().success("评价成功",0,"ok");
    }
}
