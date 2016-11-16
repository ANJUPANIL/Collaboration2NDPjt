package com.niit.collaborationpjtbackend.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.collaborationpjtbackend.model.Message;
import com.niit.collaborationpjtbackend.model.OutputMessage;

@Controller

public class chat_controller {
	
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message){
		
		System.out.println("calling the method sendmessage");
		System.out.println("Message : "+message.getMessage());
		System.out.println("Message ID : "+message.getId());
		return new OutputMessage(message,new Date());
	}

}
