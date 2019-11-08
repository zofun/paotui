package com.runningman.paotui.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.runningman.paotui.mapper.StartMapper;
import com.runningman.paotui.pojo.CommentUser;
import com.runningman.paotui.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StartServiceImpl implements StartService {
    @Autowired
    private StartMapper startMapper;

    @Override
    public String queryReputation(String username,int page,int limit) {
       List<CommentUser> orderList=this.startMapper.queryReputation(username,(page-1)*limit,limit);
       int count=this.startMapper.getUserStartCount(username);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0 );
        result.put("msg","其它数据" );
        result.put("count", count);

        ObjectMapper mapper=new ObjectMapper();
        result.put("data", orderList);
        //更改时间解析方式
        /*mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        mapper.getSerializationConfig().setDateFormat(myDateFormat);*/

        try {
            String json=mapper.writeValueAsString(result);
            return  json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

    }
    public int SumUserStart(String username){
        return this.startMapper.SumUserStart(username);
    }
}
