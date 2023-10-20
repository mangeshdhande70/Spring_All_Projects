package com.mangesh.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	private String completeAddress;
	private String floor;
	private String nearByLandMark;

}
