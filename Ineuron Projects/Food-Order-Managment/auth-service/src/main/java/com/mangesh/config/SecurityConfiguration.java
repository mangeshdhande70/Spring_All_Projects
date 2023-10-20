package com.mangesh.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mangesh.security.JwtAuthenticationEntryPoint;
import com.mangesh.security.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	

	@Autowired
	public JwtAuthenticationEntryPoint point;
		
   
	@Bean
	public SecurityFilterChain securityFilterChains(HttpSecurity http) throws Exception {
		          http
		          .csrf().disable()
//		          .cors().disable()
		          .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		         			.authorizeHttpRequests()
		         			                       .antMatchers("/admin/**")
		        		                           .hasAuthority("ADMIN")
		        		                           .antMatchers("/user/**")
		        		                           .hasAuthority("USER")
		        		                           .antMatchers("/auth/authenticate").permitAll()
		        		                           .antMatchers("/auth/**","/","/login","/user/showLogin").permitAll()
		        		                           .anyRequest().authenticated();
		        		                           
		        		                           
//		        		                           .and()
//		        		                           .formLogin().defaultSuccessUrl("/home")
//		        		                           .loginPage("/login")
//		        		                           .loginProcessingUrl("/auth/authenticate")
//		        		                           .successForwardUrl("/home")
//		        		                           .failureUrl("/user/showLogin?error")
//		        		                           .and().logout()
//		        		                           .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
//		        		                           .logoutSuccessUrl("/user/showLogin?logout");
		        		                         
		        		     http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
		                    .exceptionHandling(ex->ex.authenticationEntryPoint(point));
		
		return http.build();
		
//		   http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
//				      .permitAll());
//				    return http.build();
	}
    

}