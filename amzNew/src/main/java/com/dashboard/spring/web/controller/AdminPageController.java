package com.dashboard.spring.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.form.SearchForm;
import com.dashboard.spring.service.ItemSearchService;
import com.dashboard.to.Categories;
import com.dashboard.to.ItemAllTO;

@Controller
public class AdminPageController {

	private Logger log=Logger.getLogger(AdminPageController.class);
	
	@Autowired
	private ItemSearchService itemSearchService;
		
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView openView() {
		
		log.info("Inside AdminPageController.openView");
		SearchForm searchForm=new SearchForm();
		ModelAndView model = new ModelAndView();
		ItemAllTO allTO=this.itemSearchService.getDefaultItems();
		model.setViewName("dashboard_main");
		model.addObject("allItem",allTO);
		model.addObject("searchForm", searchForm);
		return model;

	}
	
	@RequestMapping(value = "admin", method = RequestMethod.POST)
	public ModelAndView searchSubmit(@ModelAttribute("searchForm")SearchForm form ) {
		
		log.info("Inside AdminPageController.searchSubmit");
		log.info("Form"+form);
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard_main");
		return model;

	}
	
	@ModelAttribute("categories")
	public List<Categories> populateAllCategoris(Model model) {
		log.info("Inside model before page load...");
		return this.itemSearchService.getAllCategory();
	}
	
	
}
