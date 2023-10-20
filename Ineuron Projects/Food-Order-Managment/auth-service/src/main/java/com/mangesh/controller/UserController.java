package com.mangesh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping(value = "/home")
	public ResponseEntity<String> get(){
		return ResponseEntity.ok("User Login Successfully");
	}

}
