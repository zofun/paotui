package com.runningman.paotui.mapper;


import com.runningman.paotui.pojo.InMessage;

import java.util.List;

public interface WebSocketMapper {
    public void saveChatMessage(InMessage message);

    public List<String> catchChatMessage(InMessage message);
}
