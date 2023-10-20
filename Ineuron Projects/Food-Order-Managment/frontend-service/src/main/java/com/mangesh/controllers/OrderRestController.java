package com.mangesh.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangesh.food.dto.OrderDTO;
import com.mangesh.foodordermanagement.controller.OrderController;



@RestController
@RequestMapping(value = "/ui")
public class OrderRestController {
	
	@Autowired
	private OrderController orderFrontController;
	

	@PostMapping(value = "/create")
	public ResponseEntity<String> createOrder(OrderDTO orderDTO ) {
		return orderFrontController.createUpdateOrder(orderDTO, orderDTO.getUserDTO().getUserId());
	}

}
