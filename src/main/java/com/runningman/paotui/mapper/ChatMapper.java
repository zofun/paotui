package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.pojo.ChatHistory;
import com.runningman.paotui.pojo.ChatMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
@Mapper
public interface ChatMapper {
    void insert(Chat chat);

    /**
     * 更改聊天的消息的状态（已读，未读）
     * @param id
     * @param status
     */
    void changeChatStatus(@Param("id") int id, @Param("status") String status);

    /**
     * 查询聊天记录
     * @param username
     * @param targetUsername
     * @return
     */
    List<ChatMsg> queryChatMsg(@Param("username") String username,@Param("targetUsername") String targetUsername);

    /**
     * 获取用户的历史聊天记录
     * @param username
     * @param targetUsername
     * @return
     */
    List<ChatHistory> getChatHistory(@Param("username") String username,@Param("targetUsername") String targetUsername);
}
