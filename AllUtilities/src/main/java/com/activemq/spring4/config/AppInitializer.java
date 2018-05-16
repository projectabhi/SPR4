package com.activemq.spring4.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		//ActiveMQ
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);

		//Jackson
		AnnotationConfigWebApplicationContext jsonCtx = new AnnotationConfigWebApplicationContext();
		jsonCtx.register(JsonConfig.class);
		jsonCtx.setServletContext(container);
		
		ServletRegistration.Dynamic servlet1 = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		ServletRegistration.Dynamic servlet2 = container.addServlet("dispatcher", new DispatcherServlet(jsonCtx)); 
		servlet1.setLoadOnStartup(1);
		servlet1.addMapping("/");
		
		//servlet2.setLoadOnStartup(2);
		//servlet2.addMapping("/rest");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { AppConfig.class, JsonConfig.class};
		//return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
