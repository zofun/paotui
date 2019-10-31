package com.runningman.paotui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runningman.paotui.mapper.OrderMapper;
import com.runningman.paotui.mapper.StatusMapper;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.pojo.OrderTitle;
import com.runningman.paotui.pojo.OrdersUser;
import com.runningman.paotui.pojo.Status;
import com.runningman.paotui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.service.impl
 * @versio: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public boolean makeOrder(String user,Order order) {
        try{
            order.setUser(user);
            orderMapper.insertOrder(order);
            Status status = new Status();
            status.setOrder_id(order.getId());
            status.setInfo("已发布");
            Date date = new Date();
            status.setTime(date);
            statusMapper.insertStatus(status);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order> selectOrderByUser(String user) {
        return orderMapper.selectOrderByUser(user);
    }

    @Override
    public String getAllOrderList(int page,int limit) {
        List<Order> orders = orderMapper.getAllOrder((page-1)*limit,limit);
        int count= orderMapper.getOrderCount();
        List<OrderTitle> orderTitles=new LinkedList<>();
        for (Order r:orders){
            OrderTitle orderTitle = new OrderTitle();
            orderTitle.setId(r.getId());
            orderTitle.setUser(r.getUser());
            orderTitle.setBegin(r.getBegin());
            orderTitle.setEnd(r.getEnd());
            orderTitle.setReward(r.getReward());
            orderTitles.add(orderTitle);
        }


        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","其它数据");
        result.put("count",count);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(result);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getUserOrders(String user,int page, int limit) {
        List<OrdersUser> ordersUsers = orderMapper.getUserOrders(user,(page-1)*limit,limit);
        int count= orderMapper.getUserOrderCount(user);
        List<OrdersUser> orders=new LinkedList<>();
        for (OrdersUser r:ordersUsers){
            orders.add(r);
        }


        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","其它数据");
        result.put("count",count);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(result);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
