package com.mangesh.foodordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangesh.food.dto.OrderDTO;
import com.mangesh.foodordermanagement.service.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping(value = "/create/{userId}")
	public ResponseEntity<String> createUpdateOrder(@RequestBody OrderDTO orderDTO,@PathVariable Long userId) {
		boolean isOrderCreated = orderService.addUpdateOrder(orderDTO,userId);
		HttpStatus status = isOrderCreated ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
		String responseMessage = isOrderCreated ? "Order Created Successfully" : "Failed to Create Order";
		return ResponseEntity.status(status).body(responseMessage);
	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
		OrderDTO orderDTO = orderService.getOrderById(orderId);
		HttpStatus status = orderDTO != null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(orderDTO);
	}
	
	
	@GetMapping(value = "/activeorder")
	public ResponseEntity<?> getAllActiveOrder(){
		List<OrderDTO> activeOrder = orderService.getAllActiveOrder();
		if (activeOrder!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(activeOrder);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No active order present");
	}

	
	@PostMapping(value = "/status/{orderId}")
	public ResponseEntity<String> convertStatusActiveToInactive(@PathVariable long orderId){
	
		boolean responseStatus = orderService.changeStatusActiveToInactive(orderId);
		HttpStatus status = responseStatus ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		String message = responseStatus ? "Order status has been updated." : "Order not present with this id";
		return ResponseEntity.status(status).body(message);
		
	}
	
	@PostMapping(value = "/delivered/{orderId}")
	public ResponseEntity<String> changeToOrderDeliverd(@PathVariable long orderId){
	
		boolean responseStatus = orderService.chnageToOrderDeliverd(orderId);
		HttpStatus status = responseStatus ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		String message = responseStatus ? "status of order deliverd has been updated." : "Order not present with this id";
		return ResponseEntity.status(status).body(message);
		
	}
	
}
