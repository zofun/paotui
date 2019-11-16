package com.runningman.paotui.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/getUserInfo",produces = "application/json;charset=utf-8")
    public String checkUser(HttpSession session){
        User user=(User)session.getAttribute("user");
        Map<String,Object> result=new HashMap<>();
        ObjectMapper mapper=new ObjectMapper();
        String json= null;
        if(user!=null){
            User user1= this.userService.getUser(user.getUsername());
            Map<String,Object> userList=new HashMap<>();
            userList.put("username", user1.getUsername());
            userList.put("name", user1.getName());

            result.put("code",0 );
            result.put("msg","已经登录" );
            result.put("data", userList);
            try {
                json = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
        }
        else{
            result.put("code",1006 );
            result.put("msg","未登录" );
            result.put("data", null);
            try {
                json = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
        }
    }


}
