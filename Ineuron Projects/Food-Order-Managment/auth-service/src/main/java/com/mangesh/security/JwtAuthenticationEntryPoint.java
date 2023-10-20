package com.mangesh.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;



@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		logger.info("JwtAuthenticationEntryPoint");
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
//		System.out.println("Error");
		writer.println("ACCESS DENIED !! "+ authException.getMessage());
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
//		dispatcher.forward(request, response);
	}

}
