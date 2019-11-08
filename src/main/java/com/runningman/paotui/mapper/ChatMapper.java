package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Chat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

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
}
