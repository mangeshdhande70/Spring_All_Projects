package com.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.model.User;
import com.ineuron.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value = "/get")
	public String getAdmin() {
		return "Admin only";
	}
	
	@GetMapping(value = "/getalluser")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllUsers());
	}

}
