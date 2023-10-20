package com.elasticsearch.serviceimpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.model.Order;
import com.elasticsearch.repo.OrderRepository;
import com.elasticsearch.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order findByOrderId(Long orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public Long createOrder(Order order) {
		Long orderId = System.currentTimeMillis() + new Random().nextInt(100); 
		order.setOrderId(orderId);
		return orderRepository.save(order).getOrderId();
	}
	
	

}
