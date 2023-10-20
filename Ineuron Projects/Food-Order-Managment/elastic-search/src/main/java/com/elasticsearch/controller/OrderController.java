package com.elasticsearch.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.model.Order;
import com.elasticsearch.service.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	
	
	@GetMapping(value = "/getOrder/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
		Order orderDetails = orderService.findByOrderId(orderId);
		return ResponseEntity.ok(orderDetails);
		
	}
	
	@PostMapping(value = "/createOrder")
	public ResponseEntity<Long> createOrder(@RequestBody Order order) {
		
//		Long orderId = System.currentTimeMillis() + new Random().nextInt(100); 
		logger.info("Request come for create new Order");
		long orderId = orderService.createOrder(order);
		logger.info("Order Placed Successfully");
		return ResponseEntity.ok(orderId);
		
	}
	
	

}
