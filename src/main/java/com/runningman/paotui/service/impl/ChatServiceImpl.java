package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.ChatMapper;
import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.pojo.ChatHistory;
import com.runningman.paotui.pojo.LeaveWord;
import com.runningman.paotui.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;


    @Override
    public void addChat(Chat chat) {
        chatMapper.insert(chat);
    }

    @Override
    public void changeStatus(int id, String status) {
        chatMapper.changeChatStatus(id,status);
    }

    @Override
    public void changeStatus(String username, String targetUsername, String status) {
        chatMapper.changeChatStatusOfSession(username,targetUsername,status);
    }

    @Override
    public List<ChatHistory> getChatHistory(String username, String targetUsername) {
        return chatMapper.getChatHistory(username,targetUsername);
    }

    @Override
    public List<LeaveWord> getLeaveWord(String username) {
        return chatMapper.queryLeaveWord(username);

    }
}
