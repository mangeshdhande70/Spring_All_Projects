package com.mangesh.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mangesh.dto.ApplicationUserDTO;

public interface IUserService {
	
	public ApplicationUserDTO registerUser(ApplicationUserDTO user);
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
