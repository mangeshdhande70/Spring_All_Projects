package com.mangesh.foodordermanagement.service;

import java.util.List;

import com.mangesh.food.dto.OrderDTO;

public interface IOrderService {
	
	public boolean addUpdateOrder(OrderDTO orderDTO,Long userId);
	public OrderDTO getOrderById(Long orderId);
	public List<OrderDTO> getAllActiveOrder();
	public boolean changeStatusActiveToInactive(Long orderId);
	public boolean chnageToOrderDeliverd(long orderId);
}
