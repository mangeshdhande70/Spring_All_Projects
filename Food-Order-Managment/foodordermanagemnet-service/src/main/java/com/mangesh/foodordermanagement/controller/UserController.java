package com.mangesh.foodordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangesh.food.dto.UserDTO;
import com.mangesh.foodordermanagement.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/create")
	public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
		boolean isUserAdded = userService.addUpdateUser(userDTO);
		HttpStatus status = isUserAdded ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
		String responseMessage = isUserAdded ? "User Created Successfully " : "Failed to Create User";
		return ResponseEntity.status(status).body(responseMessage);
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getOrderById(@PathVariable Long userId) {
		UserDTO userDTO= userService.getUserById(userId);
		HttpStatus status = userDTO!=null?HttpStatus.FOUND:HttpStatus.NOT_FOUND;
	    return ResponseEntity.status(status).body(userDTO) ;
	    		
	}

}
