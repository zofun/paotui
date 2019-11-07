package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.ChatMapper;
import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;


    @Override
    public void addChat(Chat chat) {
        chatMapper.insert(chat);
    }
}
