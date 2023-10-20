package com.mangesh.foodordermanagement.service;

import com.mangesh.food.dto.UserDTO;

public interface IUserService {
	
	public boolean addUpdateUser(UserDTO userDTO);
	public UserDTO getUserById(long userId);

}
