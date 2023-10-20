package com.mangesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangesh.dto.ApplicationUserDTO;
import com.mangesh.dto.AuthenticationRequest;
import com.mangesh.dto.AuthenticationResponse;
import com.mangesh.security.JwtTokenUtil;
import com.mangesh.services.IUserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public ApplicationUserDTO registerUser(@RequestBody ApplicationUserDTO userDTO) {
		logger.info("Request came for Register new User");
		return userService.registerUser(userDTO);
	}

//	@GetMapping(value =  "/authenticate")
	@PostMapping(value =  "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(
//			@ModelAttribute("newRequest")
			 AuthenticationRequest authenticationRequest
			)
			throws Exception {
		
//		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
//		authenticationRequest.setUsername("md7@gmail.com");
//		authenticationRequest.setPassword("1234");

		logger.info("User trying to Login");
		
		logger.info("Username {} ",authenticationRequest.getUsername());
		logger.info("Password {} ",authenticationRequest.getPassword());
		
		if (authenticationRequest.getUsername() != null && authenticationRequest.getPassword()!=null) {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}

			final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			logger.info("token :: -> "+jwt);
			
			AuthenticationResponse response = new AuthenticationResponse();
	        response.setJwt(jwt);
	        
	        logger.info("Response ==> ", response);
			
			return new ResponseEntity<AuthenticationResponse>(response,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<String>("Please Provide Credential",HttpStatus.BAD_REQUEST);
		}
		
		
	}

}