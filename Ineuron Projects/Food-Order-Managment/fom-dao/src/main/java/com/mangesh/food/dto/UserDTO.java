package com.mangesh.food.dto;


import java.util.ArrayList;
import java.util.List;

import com.mangesh.fomobject.Address;
import com.mangesh.fomobject.Order;
import com.mangesh.fomobject.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO{
	
	    private Long userId;
	    private String email;
		private String firstName;
		private String lastName;
	    private String password;
	    private Long contactNo;
	    private Address address;
	    private List<OrderDTO> orders = new ArrayList<>();
	    
	    
	    
	    
	    
//	    public static  User toEntity(UserDTO userDTO) {
//	        User user = new User();
//	        user.setEmail(userDTO.getEmail());
//	        user.setFirstName(userDTO.getFirstName());
//	        user.setLastName(userDTO.getLastName());
//	        user.setPassword(userDTO.getPassword());
//	        user.setContactNo(userDTO.getContactNo());
//	        user.setAddress(userDTO.getAddress());
//	        
//	        List<Order> orders = new ArrayList<>();
//	        for (OrderDTO orderDTO : userDTO.getOrders()) {
//	            Order order = new Order();
//	            order.setDeliveryCharges(orderDTO.getDeliveryCharges());
//	            order.setOrderDate(orderDTO.getOrderDate());
//	            order.setOrderId(orderDTO.getOrderId());
//	            order.setPrice(orderDTO.getPrice());
//	            order.setQuantity(orderDTO.getQuantity());
//	            order.setTotalAmount(orderDTO.getTotalAmount());
//	            order.setProductName(orderDTO.getProductName());
//	            order.setUser(user);
//	            orders.add(order);
//	        }
//	        user.setOrders(orders);
//	        
//	        return user;
//	    }

//	    public static  UserDTO toDTO(User user) {
//	        UserDTO userDTO = new UserDTO();
//	        userDTO.setUserId(user.getUserId());
//	        userDTO.setEmail(user.getEmail());
//	        userDTO.setFirstName(user.getFirstName());
//	        userDTO.setLastName(user.getLastName());
//	        userDTO.setPassword(user.getPassword());
//	        userDTO.setContactNo(user.getContactNo());
//	        userDTO.setAddress(user.getAddress());
//	        
//	        List<OrderDTO> orderDTOs = new ArrayList<>();
//	        for (Order order : user.getOrders()) {
//	            OrderDTO orderDTO = new OrderDTO();
//	            orderDTO.setDeliveryCharges(order.getDeliveryCharges());
//	            orderDTO.setOrderDate(order.getOrderDate());
//	            orderDTO.setOrderId(order.getOrderId());
//	            orderDTO.setActive(order.isActive());
//	            orderDTO.setDeliverd(order.isDeliverd());
//	            orderDTO.setPrice(order.getPrice());
//	            orderDTO.setQuantity(order.getQuantity());
//	            orderDTO.setTotalAmount(order.getTotalAmount());
//	            orderDTOs.add(orderDTO);
//	        }
//	        
//	        userDTO.setOrders(orderDTOs);
//	        return userDTO;
//	    }
//	    
	    
	    
	    
	    
	    
	    public static User toEntity(UserDTO userDTO) {
	        return User.builder()
	                .email(userDTO.getEmail())
	                .firstName(userDTO.getFirstName())
	                .lastName(userDTO.getLastName())
	                .password(userDTO.getPassword())
	                .contactNo(userDTO.getContactNo())
	                .address(userDTO.getAddress())
	                .orders(convertOrderListToEntity(userDTO.getOrders()))
	                .build();
	    }

	    private static List<Order> convertOrderListToEntity(List<OrderDTO> orderDTOs) {
	        List<Order> orders = new ArrayList<>();
	        for (OrderDTO orderDTO : orderDTOs) {
	            orders.add(Order.builder()
	                    .deliveryCharges(orderDTO.getDeliveryCharges())
	                    .orderDate(orderDTO.getOrderDate())
	                    .orderId(orderDTO.getOrderId())
	                    .price(orderDTO.getPrice())
	                    .quantity(orderDTO.getQuantity())
	                    .totalAmount(orderDTO.getTotalAmount())
	                    .productName(orderDTO.getProductName())
	                    .isActive(orderDTO.isActive())
	                    .isDeliverd(orderDTO.isDeliverd())
	                    .user(null) // Assuming you don't set the user in the DTO
	                    .build());
	        }
	        return orders;
	    }
	    
	    
	    
	    
	    public static UserDTO toDTO(User user) {
	        return UserDTO.builder()
	                .userId(user.getUserId())
	                .email(user.getEmail())
	                .firstName(user.getFirstName())
	                .lastName(user.getLastName())
	                .password(user.getPassword())
	                .contactNo(user.getContactNo())
	                .address(user.getAddress())
	                .orders(convertOrderListToDTO(user.getOrders()))
	                .build();
	    }

	    private static List<OrderDTO> convertOrderListToDTO(List<Order> orders) {
	        List<OrderDTO> orderDTOs = new ArrayList<>();
	        for (Order order : orders) {
	            orderDTOs.add(OrderDTO.builder()
	                    .deliveryCharges(order.getDeliveryCharges())
	                    .orderDate(order.getOrderDate())
	                    .orderId(order.getOrderId())
	                    .isActive(order.isActive())
	                    .isDeliverd(order.isDeliverd())
	                    .price(order.getPrice())
	                    .quantity(order.getQuantity())
	                    .totalAmount(order.getTotalAmount())
	                    .build());
	        }
	        return orderDTOs;
	    }
	    
	    

}