package com.runningman.paotui.controller;


import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("changeState")
    public Result ChangeState(int id, String state, HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user==null){
            return new Result().fail(null,"更新失败",1000);
        }
        deliveryService.changeOrderState(id,state);
        return new Result().success("更新成功",0,null);

    }
}
