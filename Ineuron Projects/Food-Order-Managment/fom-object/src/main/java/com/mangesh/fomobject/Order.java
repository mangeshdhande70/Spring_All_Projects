package com.mangesh.fomobject;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name = "Delivery_Charges")
	private Double deliveryCharges;
	
	@Column(name = "Total_Amount")
	private Double totalAmount;
	
	
	@Column(name = "Order_Date")
	private Timestamp orderDate;
	
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private Double price;
	
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
    private User user;
	
	@Column(name = "is_deliverd")
	private boolean isDeliverd=false;
	
	@Column(name = "is_Active")
	private boolean isActive=true;
	
//	public Long getUser() {
//	    return user.getUserId();
//	}

}
