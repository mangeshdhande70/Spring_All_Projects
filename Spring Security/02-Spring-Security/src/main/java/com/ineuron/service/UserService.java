package com.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ineuron.model.User;
import com.ineuron.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	private List<User> user = new ArrayList<>();
	
	public UserService() {
		user.add(new User(1L, "Dhiraj", 27f));
		user.add(new User(2L, "Vivek", 25f));
		user.add(new User(3L, "Rakesh", 25f));
		user.add(new User(4L, "Mangesh", 24f));
	}
	
	
	public List<User> getAllUsers(){
		return this.user;
	}
	
	public String createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User Created";
	}

}
