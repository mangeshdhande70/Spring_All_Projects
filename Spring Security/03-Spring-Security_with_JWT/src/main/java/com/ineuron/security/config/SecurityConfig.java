package com.ineuron.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ineuron.security.jwt.JwtAuthenticationEntryPoint;
import com.ineuron.security.jwt.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	
	@Autowired
	public JwtAuthenticationEntryPoint point;
		
	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
		
	
	@Bean
	public SecurityFilterChain securityFilterChains(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		         .cors(cors->cors.disable())
		         .authorizeHttpRequests(auth->auth.requestMatchers("/admin/**")
		        		                           .hasAuthority("ADMIN")
		        		                           .requestMatchers("/user/**")
		        		                           .hasAuthority("USER")
		        		                           .requestMatchers("/admin/getalluser").permitAll()
		        		                           .requestMatchers("/auth/login","/home/create","/home/**","/login","/log").permitAll()
		        		                           .anyRequest().authenticated())
		                    .exceptionHandling(ex->ex.authenticationEntryPoint(point))
		                    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return authenticationProvider;

	}
	
		
}
