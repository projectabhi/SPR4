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
		
		ServletRegistration.Dynamic servlet1 = container.addServlet("mq", new DispatcherServlet(ctx));
		
		//Jackson
		AnnotationConfigWebApplicationContext jsonCtx = new AnnotationConfigWebApplicationContext();
		jsonCtx.register(JsonConfig.class);
		jsonCtx.setServletContext(container);
		
		ServletRegistration.Dynamic servlet2 = container.addServlet("rest", new DispatcherServlet(jsonCtx));
		
		//Dashboard
		AnnotationConfigWebApplicationContext dbrdCtx = new AnnotationConfigWebApplicationContext();
		dbrdCtx.register(DashboardConfig.class);
		dbrdCtx.setServletContext(container);
				 
		ServletRegistration.Dynamic servlet3 = container.addServlet("dashboard", new DispatcherServlet(dbrdCtx));
		
		servlet1.setLoadOnStartup(1);
		servlet1.addMapping("/mq/*");
		
		servlet2.setLoadOnStartup(1);
		servlet2.addMapping("/rest/*");
		
		servlet3.setLoadOnStartup(1);
		servlet3.addMapping("/dashboard/*");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { AppConfig.class, JsonConfig.class, DashboardConfig.class};
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
