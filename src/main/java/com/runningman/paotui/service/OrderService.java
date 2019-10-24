package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Order;
import org.hibernate.validator.constraints.EAN;

import java.util.List;


/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.service
 * @versio: 1.0
 */

public interface OrderService {
    /**
     * 根据用户id创建订单
     * @param user
     * @param order
     * @return
     */
    boolean makeOrder(String user,Order order);


    /**
     * 根据用户名查询order
     * @param user
     * @return
     */
    List<Order> selectOrderByUser(String user);
}
