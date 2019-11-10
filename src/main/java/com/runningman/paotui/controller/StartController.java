package com.runningman.paotui.controller;

import com.runningman.paotui.pojo.AuthInfo;
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
    public String queryReputation(HttpSession session,int page,int limit){
        User user=(User)session.getAttribute("user");
        String json=this.startService.queryReputation(user.getUsername(),page,limit);
        return json;
    }

    @RequestMapping(value = "/getSumStart",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<AuthInfo> sumReputation(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<AuthInfo> authInfoList= this.startService.SumUserStart(user.getUsername());
        //String json=this.startService.queryReputation(user.getUsername(),page,limit);
        return authInfoList;
    }


}
