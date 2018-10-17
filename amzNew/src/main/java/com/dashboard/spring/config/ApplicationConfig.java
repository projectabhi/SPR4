package com.dashboard.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.dashboard.interceptor.CustomInterceptor;

@Configuration
@EnableWebMvc
@Import(value={HibernateConfiguration.class,SpringJDBCConfiguration.class})
@ComponentScan(basePackages={"com.dashboard.spring"})
public class ApplicationConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/dbmain/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
   public void addInterceptors(InterceptorRegistry registry) {
      // Register guest interceptor with single path pattern
      registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/*");
   }
}
