package com.runningman.paotui.controller;


import com.runningman.paotui.dto.Result;
import com.runningman.paotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfo")
    public Result getUserInfoByUsername(String username){

        return new Result().success(userService.getUser(username));
    }

    @RequestMapping(value = "/testException")
    public Result testExceptioinHandler(){
        throw new RuntimeException("出现异常了兄弟");
    }
}
