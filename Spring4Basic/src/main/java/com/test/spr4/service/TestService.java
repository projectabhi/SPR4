package com.test.spr4.service;

import org.apache.log4j.Logger;

public class TestService {

	static Logger log=Logger.getLogger(TestService.class);
	
	public String sayHello(String name)
	{
		log.info("Inside TestService.sayHello METHOD");
		return "Hello Mr."+name;
	}
}
