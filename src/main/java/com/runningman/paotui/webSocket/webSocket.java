package com.runningman.paotui.webSocket;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runningman.paotui.pojo.ChatMsg;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{username}/{sessionId}")
@Component
public class webSocket {
    //所有对象共享
    private static ConcurrentHashMap<String,webSocket> map=new ConcurrentHashMap<>();
    private Session session;
    private String username;
    private String sessionId; //会话id

    /**
     * 建立连接
     * @param username
     * @param session
     */
    @OnOpen
    public void connect(@PathParam("username") String username,@PathParam("sessionId") String sessionId, Session session){
        this.sessionId=sessionId;
        this.username=username;
        this.session=session;
        map.put(username+":"+sessionId,this);
        System.out.println(username+"已经连接到"+sessionId+" "+username+":"+sessionId);
    }

    /**
     * 断开连接
     */
    @OnClose
    public void close(){
        map.remove(username+":"+sessionId);
        System.out.println(username+"已经断开到"+sessionId+"的连接");
    }

    @OnMessage
    public void sendMessage(String message) throws IOException {

        ObjectMapper mapper=new ObjectMapper();
        ChatMsg chatMsg = mapper.readValue(message, ChatMsg.class);

        System.out.println(chatMsg.toString());
        webSocket ws=map.get(chatMsg.getAddressee()+":"+chatMsg.getSessionId());
        if(ws==null){
            return;
        }


        //异步发送消息
        ws.session.getAsyncRemote().sendText(mapper.writeValueAsString(chatMsg));

    }


}
