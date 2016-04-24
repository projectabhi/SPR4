package com.abhijit.webConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.abhijit.springConfig.MvcConfig;

public class Initialiser implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext mvcContext=new AnnotationConfigWebApplicationContext();
		mvcContext.register(MvcConfig.class);
		ServletRegistration.Dynamic dispather=context.addServlet("dispatcher", new DispatcherServlet(mvcContext));
		dispather.setLoadOnStartup(1);
		dispather.addMapping("/common/*");
	}

}
