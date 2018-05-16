package com.activemq.spring4.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class MessagingListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory()
	{
		DefaultJmsListenerContainerFactory factory=new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("1-1");
		return factory;
	}
}
