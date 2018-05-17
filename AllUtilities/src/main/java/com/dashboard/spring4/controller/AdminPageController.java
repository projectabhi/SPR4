package com.dashboard.spring4.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPageController {

	private Logger log=Logger.getLogger(AdminPageController.class);
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView openView() {
		
		log.info("Inside AdminPageController.openView");

		ModelAndView model = new ModelAndView();
		
		model.setViewName("dashboard_main");

		return model;

	}
}
