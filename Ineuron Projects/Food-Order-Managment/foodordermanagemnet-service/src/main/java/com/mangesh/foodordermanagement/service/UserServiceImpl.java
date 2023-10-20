package com.mangesh.foodordermanagement.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mangesh.fomobject.User;
import com.mangesh.food.dto.UserDTO;
import com.mangesh.foodordermanagement.exception.UserNotFoundException;
import com.mangesh.foodordermanagement.utils.DataUtils;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	
	
	@Autowired
	private DataUtils dataUtils;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean addUpdateUser(UserDTO userDTO) {
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		return dataUtils.addUpdateUser(UserDTO.toEntity(userDTO));
	}

	@Override
	public UserDTO getUserById(long userId) {
		Optional<User> optional = dataUtils.getUserById(userId);
		return optional.map(UserDTO::toDTO).orElseThrow(()->new UserNotFoundException("User not available for id : "+userId));
	}
	

}
