package com.mangesh.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
	
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authManager(UserDetailsService detailsService){
	        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
	        daoProvider.setUserDetailsService(detailsService);
	        daoProvider.setPasswordEncoder(passwordEncoder());
	        return new ProviderManager(daoProvider);
	    }
	    
	    
	    @Bean
	    public ModelMapper modelMapper() {
	    	return new ModelMapper();
	    }


}
