package com.mangesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	    @GetMapping(value = {"/","/login"})
	    public String getLoginPage(){
	        return "login";
	    }
	    
	    @GetMapping("/home")
	    public String getHome(){
	        return "index";
	    }
	
	
}
