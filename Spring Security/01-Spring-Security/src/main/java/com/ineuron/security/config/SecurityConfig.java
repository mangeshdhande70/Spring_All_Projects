//package com.ineuron.security.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//
//		UserDetails admin = User.withUsername("Mangesh").password(encoder.encode("12345")).roles("ADMIN").build();
//
//		UserDetails user = User.withUsername("Ankush").password(encoder.encode("12345")).roles("USER", "ADMIN", "HR")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//
//	}
//
//	@Bean
//	private PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/products/welcome", "/products/new")
//				.permitAll().and().authorizeHttpRequests().requestMatchers("/products/**").authenticated().and()
//				.formLogin().and().build();
//	}
//
//}
