package com.spring.orm.dto;

import org.springframework.stereotype.Component;

@Component("employee")
public class EmployeeDto {
	
	private Integer empId;
	
	private String name;
	
	private String unit;

	public EmployeeDto(Integer empId, String name, String unit) {
		super();
		this.empId = empId;
		this.name = name;
		this.unit = unit;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", name=" + name + ", unit=" + unit + "]";
	}

	
	
	
	
}
