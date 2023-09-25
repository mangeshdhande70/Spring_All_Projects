package com.ineuron.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ineuron.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {

//		UserDetails admin = User.builder().username("Mangesh").password(passwordEncoder().encode("12345")).roles("ADMIN").build();
//
//		UserDetails user = User.builder().username("Ankush").password(passwordEncoder().encode("12345")).roles("USER")
//				.build();

		return new UserSecurityService();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//
//				.authorizeHttpRequests((requests) -> requests.requestMatchers("/home/admin/**").hasAuthority("ADMIN")
//						.requestMatchers("/home/user/**").hasAuthority("USER")
//						.requestMatchers("/", "/home", "/home/public", "/home/create").permitAll().anyRequest()
//						.authenticated())
//				.formLogin((form) -> form
//						.loginPage("/login")
//						.defaultSuccessUrl("/home")
//						.permitAll()
//					)
//					.logout((logout) -> logout
//		                  .logoutUrl("/logout")
//						  .invalidateHttpSession(true)
//		                  .logoutSuccessUrl("/login?logout=true")
//		                  .deleteCookies("JSESSIONID")
//		                  .clearAuthentication(true)
//		                  .permitAll());
//
//		return http.build();
//	}

// for customize login page	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests.requestMatchers("/home/admin/**").hasAuthority("ADMIN")
			.requestMatchers("/home/user/**").hasAuthority("USER")
			.requestMatchers("/", "/home", "/home/public", "/home/create").permitAll().anyRequest()
			.authenticated())
			.formLogin((form) -> form
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				.permitAll()
			);

		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;

	}

}
