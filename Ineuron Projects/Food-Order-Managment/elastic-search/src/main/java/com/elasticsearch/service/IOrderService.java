package com.elasticsearch.service;

import com.elasticsearch.model.Order;

public interface IOrderService {
	
	public Order findByOrderId(Long orderId);
	
	public Long createOrder(Order order);

}
