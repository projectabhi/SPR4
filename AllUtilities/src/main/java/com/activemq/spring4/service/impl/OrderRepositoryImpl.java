package com.activemq.spring4.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.activemq.spring4.model.Order;
import com.activemq.spring4.service.OrderRepository;

@Service(value="orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

	private final Map<String, Order> orders = new ConcurrentHashMap<String, Order>();
	
	@Override
    public void putOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }
 
    @Override
    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }
 
    public Map<String, Order> getAllOrders(){
        return orders;
    }
}
