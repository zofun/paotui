package com.runningman.paotui.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.runningman.paotui.mapper.StartMapper;
import com.runningman.paotui.pojo.AuthInfo;
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
    public List<CommentUser> queryReputation(String username,int page,int limit) {
       List<CommentUser> commentUsers=this.startMapper.queryReputation(username,(page-1)*limit,limit);
       return commentUsers;

    }

    @Override
    public List<AuthInfo> SumUserStart(String username) {
        return startMapper.SumUserStart(username);
    }

    @Override
    public int getUserStartCount(String username) {
        return startMapper.getUserStartCount(username);
    }

}
