package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.StatusMapper;
import com.runningman.paotui.pojo.Status;
import com.runningman.paotui.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public void changeOrderState(int orderId, String state) {

        statusMapper.changeStatusInfo(state,orderId);
    }
}
