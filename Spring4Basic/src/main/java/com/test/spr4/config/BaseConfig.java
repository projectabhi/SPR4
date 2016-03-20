package com.test.spr4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.test.spr4.impl.dao.HibDao;
import com.test.spr4.service.TestService;

@Configuration
@ComponentScan({"com.test.spr4.config"})
public class BaseConfig {

	@Bean(name="hello")
	public TestService getService()
	{
		return new TestService();
	}
	
	@Bean(name="HibDao")
	public HibDao getHibDao()
	{
		return new HibDao();
	}
}
