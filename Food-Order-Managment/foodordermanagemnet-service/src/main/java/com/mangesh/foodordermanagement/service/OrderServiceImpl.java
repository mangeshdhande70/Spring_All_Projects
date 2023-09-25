package com.mangesh.foodordermanagement.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangesh.fomobject.Order;
import com.mangesh.fomobject.User;
import com.mangesh.food.dto.OrderDTO;
import com.mangesh.food.dto.ProductDTO;
import com.mangesh.foodordermanagement.exception.OrderNotFoundException;
import com.mangesh.foodordermanagement.utils.DataUtils;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private DataUtils dataUtils;

//	@Autowired
//	private IUserService userService;
	
	@Autowired
	private IProductService productService;

	@Override
	public boolean addUpdateOrder(OrderDTO orderDTO, Long userId) {
	
		ProductDTO productDTO  = productService.getProductDetailsByProductName(orderDTO.getProductName());
		orderDTO.setDeliveryCharges(30.0);
		orderDTO.setPrice(productDTO.getPrice());
		orderDTO.setTotalAmount((orderDTO.getPrice() * orderDTO.getQuantity()) + orderDTO.getDeliveryCharges());
		orderDTO.setOrderDate(new Timestamp(System.currentTimeMillis()));
		Optional<User> optional = dataUtils.getUserById(userId);
		if (optional.isPresent()) {
			Order order = OrderDTO.toEntity(orderDTO);
			order.setUser(optional.get());
			logger.info("Order saved in DB");
			return dataUtils.createUpdateOrder(order);

		}
		return false;
	}

	@Override
	public OrderDTO getOrderById(Long orderId) {
		Optional<Order> optional = dataUtils.getOrderById(orderId);
		logger.info("After get order from DB");
		return optional.map(OrderDTO::toDTO)
				.orElseThrow(() -> new OrderNotFoundException("Order not present for given order id : " + orderId));
	}

	@Override
	public List<OrderDTO> getAllActiveOrder() {
		
//		List<Order> allActiveOrder = dataUtils.getAllActiveOrder();	
//		System.out.println("OrderServiceImpl.getAllActiveOrder()");
//		System.out.println(allActiveOrder.get(1).isActive());

		List<OrderDTO> activeOrderDTOsList = dataUtils.getAllActiveOrder().stream()
		        .map(OrderDTO::toDTO)
		        .collect(Collectors.toList());
	

		return activeOrderDTOsList;
	}

	@Override
	public boolean changeStatusActiveToInactive(Long orderId) {
		 Order order = dataUtils.getOrderById(orderId).orElse(null);

		    if (order != null) {
		        order.setActive(false);
		        dataUtils.createUpdateOrder(order);
		        return true;
		    }

		    return false;
	}

	@Override
	public boolean chnageToOrderDeliverd(long orderId) {
		 Order order = dataUtils.getOrderById(orderId).orElse(null);
		    if (order != null) {
		        order.setDeliverd(true);
		        dataUtils.createUpdateOrder(order);
		        return true;
		    }

		    return false;
	}
	
	
//	@Override
//	public OrderDTO getOrderById(Long orderId) {
//		Optional<Order> optional = dataUtils.getOrderById(orderId);
//		Order order = optional.get();
//		    OrderDTO orderDTO = new OrderDTO();
//	        orderDTO.setOrderId(order.getOrderId());
//	        orderDTO.setDeliveryCharges(order.getDeliveryCharges());
//	        orderDTO.setTotalAmount(order.getTotalAmount());
//	        orderDTO.setOrderDate(order.getOrderDate());
//	        orderDTO.setProductName(order.getProductName());
//	        orderDTO.setPrice(order.getPrice());
//	        orderDTO.setQuantity(order.getQuantity());
//	        
//	        UserDTO userDTO = new UserDTO();
//	        userDTO.setUserId(order.getUser().getUserId());
//	        orderDTO.setUserDTO(userDTO);
//		return orderDTO;
//	
//	}

}
