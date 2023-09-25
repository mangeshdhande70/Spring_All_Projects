package com.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain configureFilter(HttpSecurity http) throws Exception {
		//authorization
		http.authorizeHttpRequests()
		.requestMatchers("/","/home","/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login();//Developing custom login form having hyperlink to login as fb user
		return http.build();
	}
	
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http .authorizeHttpRequests((requests) ->
	 * requests.requestMatchers("/home/admin/**").hasAuthority("ADMIN")
	 * .requestMatchers("/home/user/**").hasAuthority("USER")
	 * .requestMatchers("/","/home","/login").permitAll()
	 * .anyRequest().authenticated()) .formLogin((form) -> form .loginPage("/login")
	 * .defaultSuccessUrl("/home") .permitAll() ).oauth2Login();
	 * 
	 * return http.build(); }
	 */

}
