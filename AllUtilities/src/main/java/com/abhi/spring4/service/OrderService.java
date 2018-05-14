package com.abhi.spring4.service;

import java.util.Map;

import com.abhi.spring4.model.InventoryResponse;
import com.abhi.spring4.model.Order;

public interface OrderService {

	public void sendOrder(Order order);
    
    public void updateOrder(InventoryResponse response);
     
    public Map<String, Order> getAllOrders();
}
