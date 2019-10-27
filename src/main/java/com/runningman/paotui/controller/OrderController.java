package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.controller
 * @versio: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/makeorder",method = RequestMethod.POST)
    public Result makeOrder(HttpSession session, Order order){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result().fail("nologin","未登录",0);
        }else{
            if(orderService.makeOrder(user.getUsername(),order)) {
                return new Result().success("ok",0,"发布成功");
            }
            else {
                return new Result().fail("error","网络出错",0);
            }
        }
    }
}
