package com.abhijit.controller.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

	private static final Logger logger = Logger.getLogger(CommonController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	  logger.info("Welcome home!");
	  return "home";
	 }
}
