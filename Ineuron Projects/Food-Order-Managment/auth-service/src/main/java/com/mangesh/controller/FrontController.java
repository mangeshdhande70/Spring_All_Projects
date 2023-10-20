package com.mangesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mangesh.dto.AuthenticationRequest;

@Controller
public class FrontController {

	
	    @GetMapping(value = {"/","/login"})
	    public String getLoginPage(@ModelAttribute("newRequest")AuthenticationRequest authenticationRequest ){
	    	
	        return "login";
	    }
	    
	    @GetMapping("/home")
	    public String getHome(){
	        return "index";
	    }
	    
	    
	    @GetMapping("/failed")
	    public String getFailedLoginPage(){
	        return "login_failed";
	    }
	
	
}
