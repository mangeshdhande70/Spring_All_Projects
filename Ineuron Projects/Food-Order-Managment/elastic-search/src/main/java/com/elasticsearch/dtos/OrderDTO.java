package com.elasticsearch.dtos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderDTO {
	
	  
		private Long orderId;
		private Double deliveryCharges;
		private Double totalAmount;
		private Timestamp orderDate;
		private String productName;
		private Double price;
		private Integer quantity;

}
