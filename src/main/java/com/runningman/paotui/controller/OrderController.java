package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private OrderService orderService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }


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

    @RequestMapping(value = "/getAllOrder",produces = "application/json;charset=utf-8")
    public String getAllOrder(int page,int limit){
        String json = orderService.getAllOrderList(page,limit);
        return json;
    }

    @RequestMapping(value = "/getUserOrders" ,produces = "application/json;charset=utf-8")
    public String getUserOrders(HttpSession session, int page, int limit){
        User user = (User)session.getAttribute("user");
        String json = orderService.getUserOrders(user.getUsername(),page,limit);
        return json;
    }

    @RequestMapping(value = "/getInfo",produces = "application/json;charset=utf-8")
    public String getOrderInfo(int id){
        String json = orderService.getOrderInfo(id);
        return json;
    }
}
