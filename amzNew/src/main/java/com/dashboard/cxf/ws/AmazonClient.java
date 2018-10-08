package com.dashboard.cxf.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.amazon.webservices.awsecommerceservice.AWSECommerceService;
import com.amazon.webservices.awsecommerceservice.AWSECommerceServicePortType;

public class AmazonClient {

	public static AWSECommerceServicePortType getClient(String action)
	{
		AWSECommerceService awsecommerceservice = new AWSECommerceService();
		awsecommerceservice.setHandlerResolver(new HandlerResolver() {

            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlerList = new ArrayList<Handler>();
                handlerList.add(new AmazonSOAPHandler(action));
                return handlerList;
            }
        });
		
		JaxWsProxyFactoryBean factory=new JaxWsProxyFactoryBean();
		factory.setAddress("https://webservices.amazon.in/onca/soap?Service=AWSECommerceService");
		factory.setServiceClass(AWSECommerceServicePortType.class);
		List<Handler> handlerList = new ArrayList<Handler>();
        handlerList.add(new AmazonSOAPHandler(action));
		factory.setHandlers(handlerList);
		factory.getOutInterceptors().add(new RequestInterceptor());
		factory.getInInterceptors().add(new ResponseInterceptor());
		AWSECommerceServicePortType client = (AWSECommerceServicePortType)factory.create();
		
		return client;
	}
}
