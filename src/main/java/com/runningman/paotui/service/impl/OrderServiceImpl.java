package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.OrderMapper;
import com.runningman.paotui.pojo.Order;
import com.runningman.paotui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.service.impl
 * @versio: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean makeOrder(String user,Order order) {
        try{
            order.setUser(user);
            orderMapper.insertOrder(order);
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
}
