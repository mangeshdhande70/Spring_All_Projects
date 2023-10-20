package com.elasticsearch.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "orders")
public class Order {
	
    @Id
	private Long orderId;
	private Double deliveryCharges;
	private Double totalAmount;
	private Timestamp orderDate;
	private String productName;
	private Double price;
	private Integer quantity;

}
