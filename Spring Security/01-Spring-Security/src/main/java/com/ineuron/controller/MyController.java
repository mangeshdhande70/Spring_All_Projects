package com.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.model.Users;
import com.ineuron.service.UserService;

@RestController
@RequestMapping(value = "/secure")
public class MyController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/public")
	public String get() {
		return "Welcome message";
	}
	

	@GetMapping(value = "/admin")
	public String getAdmin() {
		return "Admin only";
	}
	

	@GetMapping(value = "/user")
	public List<Users> getUser() {
		return userService.getAllUsers();
	}
	
	
	

}
