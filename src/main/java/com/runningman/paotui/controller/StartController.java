package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.AuthInfo;
import com.runningman.paotui.pojo.CommentUser;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.StartService;
import com.runningman.paotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("personal")
public class StartController {

    @Autowired
    private StartService startService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserStart",produces = "application/json;charset=utf-8")
    public Result queryReputation(HttpSession session, int page, int limit){
        User user=(User)session.getAttribute("user");
        List<CommentUser> commentUsers = startService.queryReputation(user.getUsername(),page,limit);
        if(user==null){
            return new Result().fail("nologin","未登录",0);
        }
        return new Result().success("用户",0,commentUsers,startService.getUserStartCount(user.getUsername()));
    }

    @RequestMapping(value = "/getSumStart",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<AuthInfo> sumReputation(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<AuthInfo> authInfoList= startService.SumUserStart(user.getUsername());
        //String json=this.startService.queryReputation(user.getUsername(),page,limit);
        return authInfoList;
    }


}
