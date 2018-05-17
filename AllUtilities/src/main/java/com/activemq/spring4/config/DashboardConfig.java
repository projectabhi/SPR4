package com.activemq.spring4.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.dashboard.spring4")
public class DashboardConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/dashboard/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	public void configureMessageConverter(List<HttpMessageConverter<?>> converters)
	{
		Jackson2ObjectMapperBuilder builder=new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
}
