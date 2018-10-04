package com.dashboard.spring.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserServiceController {
	private Logger log=Logger.getLogger(UserServiceController.class);
	
	@RequestMapping(value="/getUserCount", method=RequestMethod.GET)
	@ResponseBody
	public String getAllUsers()
	{
		log.info("Inside user service controller...");
		return "10";
	}
}
