package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.mapper
 * @versio: 1.0
 */
@Repository
@Mapper
public interface OrderMapper {
    void insertOrder(Order order);

    List<Order> selectOrderByUser(String user);
}
