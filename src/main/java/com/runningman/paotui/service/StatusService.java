package com.runningman.paotui.service;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/6
 * @Description: com.runningman.paotui.service
 * @versio: 1.0
 */
public interface StatusService {
    /**
     * 根据订单id更改订单状态
     * @param info
     * @param order_id
     */
    void changeStatusInfo(String info, int order_id);

    /**
     * 获取订单的状态
     * @param order_id
     * @return
     */
    String getStatusInfo(int order_id);
}
