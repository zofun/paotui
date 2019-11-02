package com.runningman.paotui.controller;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 处理用户注册的请求
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(User user){
        try {
            userService.addUser(user);
            return new Result().success("注册成功",0,"ok");
        }catch (Exception e){
            //捕获主键重复异常，即电话已被注册
            return new Result().fail("error","注册失败,电话被占用",0);
        }



    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login( User user, HttpSession session){
        if(userService.checkUser(user)){
            session.setAttribute("user",user);
            System.out.println(user.toString());
            return new Result().success("登录成功",0,"pass");
        }
        return new Result().fail("nopass","登录失败",0);
    }
}
