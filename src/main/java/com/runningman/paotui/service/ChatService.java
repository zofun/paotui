package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.pojo.ChatHistory;

import java.util.List;

public interface ChatService {
    void addChat(Chat chat);

    /**
     * 更改聊天信息的状态
     * @param id
     * @param status
     */
    void changeStatus(int id,String status);

    /**
     * 获取用户的聊天记录
     * @param username
     * @param targetUsername
     * @return
     */
    List<ChatHistory> getChatHistory(String username, String targetUsername);
}
