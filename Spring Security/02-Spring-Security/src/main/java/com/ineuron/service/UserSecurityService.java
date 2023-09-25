package com.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ineuron.model.User;
import com.ineuron.repo.UserRepository;
import com.ineuron.security.config.UserInfo;

@Component
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Optional<User> user = userRepository.findByEmail(username);
		 return user.map(UserInfo::new).orElseThrow(()->new UsernameNotFoundException("user not present"));
	}

}
