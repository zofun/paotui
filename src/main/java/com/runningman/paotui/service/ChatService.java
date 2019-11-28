package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.pojo.ChatHistory;
import com.runningman.paotui.pojo.ChatMsg;
import com.runningman.paotui.pojo.LeaveWord;

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
     * 将username发送给targetUsername的所有消息，更改状态
     * @param username
     * @param targetUsername
     */
    void changeStatus(String username,String targetUsername,String status);

    /**
     * 获取用户的聊天记录
     * @param username
     * @param targetUsername
     * @return
     */
    List<ChatHistory> getChatHistory(String username, String targetUsername);

    /**
     * 查询该用户的未读消息
     * @param username
     * @return
     */
    List<LeaveWord> getLeaveWord(String username);


}
