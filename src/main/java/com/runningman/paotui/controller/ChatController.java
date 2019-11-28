package com.runningman.paotui.controller;

import com.runningman.paotui.dto.Result;
import com.runningman.paotui.pojo.LeaveWord;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.awt.font.TextAttribute;
import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/15
 * @Description: com.runningman.paotui.controller
 * @versio: 1.0
 */
@RestController
@RequestMapping("chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "getChatHis")
    public Result getChatHistory(String username, String targetUsername){
        return new Result().success("聊天记录",0,chatService.getChatHistory(username,targetUsername));
    }


    @RequestMapping(value = "getMsgList")
    public Result getMsgList(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user==null){
            return new Result().fail("未登录",1000);
        }
        List<LeaveWord> list = chatService.getLeaveWord(user.getUsername());
        return new Result().success("留言",0,list);
    }

    /**
     * 键username发送给targetUsername的所有未读消息，标记为以读
     * @param username
     * @param targetUsername
     * @return
     */
    @RequestMapping(value = "changeMsgState")
    public Result changeMsgState(String username,String targetUsername){
        System.out.println("收到请求");
        chatService.changeStatus(username,targetUsername,"y");
        return new Result().success();
    }
}
