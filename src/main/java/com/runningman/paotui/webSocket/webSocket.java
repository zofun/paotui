package com.runningman.paotui.webSocket;



import com.fasterxml.jackson.databind.ObjectMapper;

import com.runningman.paotui.mapper.ChatMapper;
import com.runningman.paotui.pojo.Chat;
import com.runningman.paotui.pojo.ChatMsg;

import com.runningman.paotui.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{username}/{targetUsername}")
@Component
public class webSocket {

    /**
     * 存储会话对象的map，该类的所有实例共享
     */
    private static ConcurrentHashMap<String,webSocket> map=new ConcurrentHashMap<>();
    private Session session;
    /**
     * 自身用户名
     */
    private String username;

    /**
     * 会话目标用户名
     */
    private String targetUsername;

    /**
     * 用于注入service
     */
    private static ApplicationContext applicationContext;
    private ChatService chatService;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        webSocket.applicationContext = applicationContext;
    }

    /**
     * 建立连接
     * @param username
     * @param session
     */
    @OnOpen
    public void connect(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername, Session session){
        this.chatService = applicationContext.getBean(ChatService.class);
        this.targetUsername=targetUsername;
        this.username=username;
        this.session=session;

        map.put(username+":"+targetUsername,this);
        System.out.println(username+"已经连接到"+targetUsername);
    }

    /**
     * 断开连接
     */
    @OnClose
    public void close(){
        map.remove(username+":"+targetUsername);
        System.out.println(username+"已经断开到"+targetUsername+"的连接");
    }

    @OnMessage
    public void sendMessage(String message) throws IOException {

        ObjectMapper mapper=new ObjectMapper();
        ChatMsg chatMsg = mapper.readValue(message, ChatMsg.class);

        System.out.println(chatMsg.toString());
        webSocket ws=map.get(chatMsg.getAddressee()+":"+chatMsg.getSenderId());
        //持久化聊天信息
        Chat chat = new Chat();
        chat.setSender(chatMsg.getSenderId());
        chat.setAddressee(chatMsg.getAddressee());
        chat.setInfo(chatMsg.getMessage());

        chat.setTime(new Date());
        if(ws==null){
            //对方不在线，标记信息为未读状态，持久化到数据库
            chat.setStatus("n");
            chatService.addChat(chat);
            return;
        }
        //对方在线，将消息标记为已读，持久化到数据库
        chat.setStatus("y");
        chatService.addChat(chat);

        //异步发送消息
        ws.session.getAsyncRemote().sendText(mapper.writeValueAsString(chatMsg));

    }


}
