package com.test.spr4.Spring4Basic;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.spr4.impl.dao.HibDao;
import com.test.spr4.service.TestService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger log=Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.info( "Initializing ..." );
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext("com.test.spr4.config");
        TestService test=(TestService)ctx.getBean("hello");
        log.info(test.sayHello("Abhijit"));
        HibDao hibDao=(HibDao)ctx.getBean("HibDao");
        hibDao.getUsers();
    }
}
