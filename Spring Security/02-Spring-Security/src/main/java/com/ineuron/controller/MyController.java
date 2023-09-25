package com.ineuron.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.model.User;
import com.ineuron.service.UserService;

@RestController
@RequestMapping(value = "/home")
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
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping(value = "/create")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	@GetMapping(value = "/create")
	public String getString() {
		return "public";
	}


	
//	
//	@GetMapping(value = "/logout")
//	public String getLogout() {
//		return "Logout Page";
//	}
//	
	
	
	
	@GetMapping(value = "/getCurrentUser")
	public String getCurrentUserName(Principal principal) {
		return principal.getName();
	}
	
	

}
