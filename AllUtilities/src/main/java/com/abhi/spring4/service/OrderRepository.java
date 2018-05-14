package com.abhi.spring4.service;

import java.util.Map;

import com.abhi.spring4.model.Order;

public interface OrderRepository {

	public void putOrder(Order order);
    
    public Order getOrder(String orderId);
     
    public Map<String, Order> getAllOrders();
}
