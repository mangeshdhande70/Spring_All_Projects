package com.mangesh.fomobject;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private String completeAddress;
	private String floor;
	private String nearByLandMark;

}
