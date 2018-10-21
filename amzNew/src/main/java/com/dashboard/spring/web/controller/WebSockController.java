package com.dashboard.spring.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSockController {

	@MessageMapping("/random")
	@SendTo("/topic")
	public String send() throws Exception {
		System.out.println("Sending message");
        return "Test"; 
    }
}
