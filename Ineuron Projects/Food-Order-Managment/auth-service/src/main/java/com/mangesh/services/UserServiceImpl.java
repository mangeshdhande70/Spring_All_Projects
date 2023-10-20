package com.mangesh.services;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mangesh.dto.ApplicationUserDTO;
import com.mangesh.model.ApplicationUser;
import com.mangesh.repository.UserRepository;



@Service
public class UserServiceImpl implements UserDetailsService,IUserService {

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    
    @Override
    public ApplicationUserDTO registerUser(ApplicationUserDTO user) {
    	
		List<GrantedAuthority> authorities = new ArrayList<>();
		String[] roles = user.getRoles().split(",");
		for(String role:roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAuthorities(authorities);
		Long userId = userRepository.save(modelMapper.map(user, ApplicationUser.class)).getUserId();
		user.setUserId(userId);
		user.setPassword(null);
		return user;
	}

}