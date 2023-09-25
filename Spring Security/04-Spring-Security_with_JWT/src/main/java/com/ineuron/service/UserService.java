package com.ineuron.service;

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
	
		
	public List<User> getAllUsers(){
		
		List<User> list = userRepository.findAll();
		
		list.forEach(user->{
			user.setPassword(null);
		});
		
		return userRepository.findAll();
	}
	
	public String createUser(User user) {
//		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User Created";
	}

}
