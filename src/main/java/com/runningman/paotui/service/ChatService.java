package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Chat;

public interface ChatService {
    void addChat(Chat chat);

    /**
     * 更改聊天信息的状态
     * @param id
     * @param status
     */
    void changeStatus(int id,String status);
}
