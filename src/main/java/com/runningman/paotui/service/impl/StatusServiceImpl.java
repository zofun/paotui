package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.StatusMapper;
import com.runningman.paotui.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/6
 * @Description: com.runningman.paotui.service.impl
 * @versio: 1.0
 */
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusMapper statusMapper;


    @Override
    public void changeStatusInfo(String info, int order_id) {
        statusMapper.changeStatusInfo(info, order_id);
    }

    @Override
    public String getStatusInfo(int order_id) {
        return statusMapper.getStatusInfo(order_id);
    }
}
