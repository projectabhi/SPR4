package com.test.spr4.Spring4Basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.spr4.service.TestService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Initializing ..." );
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext("com.test.spr4.config");
        TestService test=(TestService)ctx.getBean("hello");
        System.out.println(test.sayHello("Abhijit"));
    }
}
