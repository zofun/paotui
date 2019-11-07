package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.pojo.OrderInfo;
import com.runningman.paotui.pojo.OrdersUser;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.OrderService;
import com.runningman.paotui.service.StatusService;
import com.runningman.paotui.service.UserService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

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

    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Result getAllOrder(int page,int limit){
        List<Order> order = orderService.getAllOrderList(page,limit);
        int count = orderService.getOrderCount();
        Result result = new Result();
        return result.success("其它数据",0,order,count);

    }

    @RequestMapping(value = "/getUserOrders" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Result getUserOrders(HttpSession session, int page, int limit){
        User user = (User)session.getAttribute("user");

        if(user.getUsername()==null){
            return new Result().fail("nologin","未登录",0);
        }else{
            int count = orderService.getUserOrderCount(user.getUsername());
            List<OrdersUser> ordersUsers = orderService.getUserOrders(user.getUsername(),page,limit);
            return new Result().success("其它数据",0,ordersUsers,count);
        }


    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Result getOrderInfo(int id){
        OrderInfo orderInfo = orderService.getOrderInfo(id);
        return new Result().success("订单的详细信息",0,orderInfo);
    }

    @RequestMapping(value = "/takeOrder",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result takeOrder(int id,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(userService.getUserAuth(user.getUsername())==0){
            return new Result().fail(1002,"你不是跑腿员，没有接单权限");
        }
        if(statusService.getStatusInfo(id)!="已发布"){
            return new Result().fail(1003,"接单失败");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endtime = format.format(orderService.getOrderEndTime(id));
        Date ten = null;
        Date now = null;
        try {
            ten = format.parse(endtime);
            now = new Date();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(ten.before(now)){
            return new Result().fail(1003,"该订单失效");
        }

        orderService.setDelivery(id,user.getUsername());
        statusService.changeStatusInfo("已接单",id);
        return new Result().success("接单成功，请及时完成",0,null);
    }
}
