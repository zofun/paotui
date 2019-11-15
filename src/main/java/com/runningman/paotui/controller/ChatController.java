package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/15
 * @Description: com.runningman.paotui.controller
 * @versio: 1.0
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/getChatHis")
    public Result getChatHistory(String username, String targetUsername){
        return new Result().success("聊天记录",0,chatService.getChatHistory(username,targetUsername));
    }
}
