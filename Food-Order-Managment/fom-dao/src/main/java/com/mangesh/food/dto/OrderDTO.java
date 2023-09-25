package com.mangesh.food.dto;




import java.sql.Timestamp;

import com.mangesh.fomobject.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO{
	
	private Long orderId;
	private Double deliveryCharges;
	private Double totalAmount;
	private Timestamp orderDate;
	private String productName;
	private Double price;
	private Integer quantity;
	private boolean isDeliverd;
	private boolean isActive;
    private UserDTO userDTO;
    

//    public static Order toEntity(OrderDTO orderDTO) {
//        Order order = new Order();
//        order.setOrderId(orderDTO.getOrderId());
//        order.setDeliveryCharges(orderDTO.getDeliveryCharges());
//        order.setTotalAmount(orderDTO.getTotalAmount());
//        order.setOrderDate(orderDTO.getOrderDate());
//        order.setProductName(orderDTO.getProductName());
//        order.setPrice(orderDTO.getPrice());
//        order.setQuantity(orderDTO.getQuantity());
//        
////        User user = UserDTO.toEntity(orderDTO.getUserDTO());
////        order.setUser(user);
//        
//        return order;
//    }

//    public static OrderDTO toDTO(Order order) {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setOrderId(order.getOrderId());
//        orderDTO.setDeliveryCharges(order.getDeliveryCharges());
//        orderDTO.setActive(order.isActive());
//        orderDTO.setTotalAmount(order.getTotalAmount());
//        orderDTO.setOrderDate(order.getOrderDate());
//        orderDTO.setProductName(order.getProductName());
//        orderDTO.setPrice(order.getPrice());
//        orderDTO.setQuantity(order.getQuantity());
//        orderDTO.setDeliverd(order.isDeliverd());
//        
//        UserDTO userDTO = new UserDTO();
//        userDTO.setAddress(order.getUser().getAddress());
//        userDTO.setContactNo(order.getUser().getContactNo());
//        userDTO.setFirstName(order.getUser().getFirstName());
//        userDTO.setLastName(order.getUser().getLastName());
//        userDTO.setUserId(order.getUser().getUserId());
//        
//        orderDTO.setUserDTO(userDTO);
//        
//        return orderDTO;
//    }
	  
    
    public static Order toEntity(OrderDTO orderDTO) {
        return Order.builder()
                .orderId(orderDTO.getOrderId())
                .deliveryCharges(orderDTO.getDeliveryCharges())
                .totalAmount(orderDTO.getTotalAmount())
                .orderDate(orderDTO.getOrderDate())
                .productName(orderDTO.getProductName())
                .price(orderDTO.getPrice())
                .quantity(orderDTO.getQuantity())
                .build();
    }

    
    public static OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .deliveryCharges(order.getDeliveryCharges())
                .isActive(order.isActive())
                .totalAmount(order.getTotalAmount())
                .orderDate(order.getOrderDate())
                .productName(order.getProductName())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .isDeliverd(order.isDeliverd())
                .userDTO(UserDTO.builder()
                        .address(order.getUser().getAddress())
                        .contactNo(order.getUser().getContactNo())
                        .firstName(order.getUser().getFirstName())
                        .lastName(order.getUser().getLastName())
                        .userId(order.getUser().getUserId())
                        .build())
                .build();
    }
    

}
