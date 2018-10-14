package com.dashboard.spring.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.spring.service.ItemSearchService;
import com.dashboard.to.ItemAllTO;

@Controller
public class AdminPageController {

	private Logger log=Logger.getLogger(AdminPageController.class);
	
	@Autowired
	private ItemSearchService itemSearchService;
		
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView openView() {
		
		log.info("Inside AdminPageController.openView");
		ModelAndView model = new ModelAndView();
		ItemAllTO allTO=this.itemSearchService.getDefaultItems();
		itemSearchService.getAllCategory();
		model.setViewName("dashboard_main");
		model.addObject("allItem",allTO);
		return model;

	}
}
