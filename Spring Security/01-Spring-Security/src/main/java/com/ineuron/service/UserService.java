package com.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ineuron.model.Users;

@Service
public class UserService {
	
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	private List<Users> user = new ArrayList<>();
	
	public UserService() {
		user.add(new Users(1, "Dhiraj", 27f));
		user.add(new Users(2, "Vivek", 25f));
		user.add(new Users(3, "Rakesh", 25f));
		user.add(new Users(4, "Mangesh", 24f));
	}
	
	
	public List<Users> getAllUsers(){
		return user;
	}

}
