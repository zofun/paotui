package com.runningman.paotui;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runningman.paotui.mapper.OrderMapper;
import com.runningman.paotui.pojo.Comment;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.*;
import org.hibernate.validator.constraints.EAN;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PaotuiApplication.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class PaotuiApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    @Autowired
    private AuthService authService;

    @Test
    void contextLoads() {
    }

    @Test
    void makeOrderTest(){
        Order order = new Order();
        order.setTitle("Titile");
        order.setUser("1");
        order.setBegin("Begin");
        order.setEnd("End");
        order.setStart_Lnglat("Start_Lnglat");
        order.setReward("Reward");
        order.setEnd_lnglat("End_lnglat");
        order.setEndtime(now());
        orderMapper.insertOrder(order);

        List<Order> orderList = orderMapper.selectOrderByUser("1");

        for (Order order1:orderList){
            System.out.println(order1.toString());
        }
    }


    @Test
    void orderServiceTest(){
        /*Order order = new Order();
        order.setTitle("Titile");
        //order.setUser("1");
        order.setBegin("Begin");
        order.setEnd("End");
        order.setStart_Lnglat("Start_Lnglat");
        order.setReward("Reward");
        order.setEnd_lnglat("End_lnglat");
        order.setEndtime(now());
        orderService.makeOrder("1",order);
        System.out.println(order.getId());
        //orderService.selectOrderByUser("1");*/
        System.out.println(orderService.getAllOrderList(1,10));
        System.out.println(orderService.getUserOrders("2",1,10));
        orderService.setDelivery(1,"1");
        statusService.changeStatusInfo("已发布",13);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endtime = format.format(orderService.getOrderEndTime(13));
        System.out.println(endtime);
        System.out.println(orderService.getOrderInfo(16));
        System.out.println(userService.getUserAuth("1"));
        System.out.println(statusService.getStatusInfo(10));
    }


    @Test
    void testComment(){
        /*Comment comment = new Comment();
        comment.setInfo("不错");
        comment.setOrder_id(3);
        comment.setStart(2);
        comment.setUser("1");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try{
            time = dateFormat.parse(dateFormat.format(new Date()));
        }catch (ParseException e){
            e.printStackTrace();
        }
        comment.setTime(time);
        commentService.insertComment(comment);*/

        //authService.changeAuthStart("1",-2);

        System.out.println(authService.getAuthStart("1"));
    }


}
