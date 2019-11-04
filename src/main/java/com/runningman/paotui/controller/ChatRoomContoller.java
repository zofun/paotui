package com.runningman.paotui.controller;

import com.runningman.paotui.pojo.InMessage;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.WebSocketService;
import com.runningman.paotui.pojo.InMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 
 * 功能描述：简单版单人聊天
 */
@Controller
public class ChatRoomContoller {

	@Autowired
	private WebSocketService ws;
	
	
	@MessageMapping({"/single/chat"})
	public void singleChat(InMessage message, HttpSession session) {

		String name=(String)session.getAttribute("name");
		message.setFrom(name);
		message.setTo("b");
		ws.sendChatMessage(message);
		//每次调用，一条一条存到数据库
		ws.saveChatMessage(message);
		
	}

/*
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String userLogin(@RequestParam(value="name")String name,
							HttpServletRequest request,HttpSession session) {

			User user = new User();
			user.setName(name);
			request.getSession().setAttribute("name", name);
			//session.setAttribute("name", name);
			//String sessionId = session.getId();
			//onlineUser.put(sessionId, user);
			return "view/index";

	}
*/


}
