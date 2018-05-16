package com.activemq.spring4.service.impl;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activemq.spring4.messaging.MessageSender;
import com.activemq.spring4.model.InventoryResponse;
import com.activemq.spring4.model.Order;
import com.activemq.spring4.model.OrderStatus;
import com.activemq.spring4.service.OrderRepository;
import com.activemq.spring4.service.OrderService;
import com.activemq.spring4.util.BasicUtil;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {

	static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	 
	@Autowired
	MessageSender messageSender;
	     
    @Autowired
	OrderRepository orderRepository;
    
    @Override
    public void sendOrder(Order order) {
    	log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        order.setOrderId(BasicUtil.getUniqueId());
        order.setStatus(OrderStatus.CREATED);
        orderRepository.putOrder(order);
        log.info("Application : sending order request {}", order);
        messageSender.sendMessage(order);
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
 
    @Override
    public void updateOrder(InventoryResponse response) {
         
        Order order = orderRepository.getOrder(response.getOrderId());
        if(response.getReturnCode()==200){
            order.setStatus(OrderStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            order.setStatus(OrderStatus.FAILED);
        }else{
            order.setStatus(OrderStatus.PENDING);
        }
        orderRepository.putOrder(order);
    }
     
    public Map<String, Order> getAllOrders(){
    	Map<String, Order> orders= orderRepository.getAllOrders();
    	for(Map.Entry<String, Order> entry:orders.entrySet())
    	{
    		log.info("Key:"+entry.getKey()+"~~Value:"+entry.getValue());
    	}
    	return orders;
    }
}
