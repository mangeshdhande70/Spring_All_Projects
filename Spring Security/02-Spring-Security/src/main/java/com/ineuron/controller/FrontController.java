package com.ineuron.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FrontController {
	

	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}
	
    @PostMapping("/login")
    public String loginError() {
        return "redirect:/login?error=true";
    }

    @GetMapping(value="/logout")  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/home";  
     }  
    
    
    @GetMapping(value = "/home")
    public String getHomePage(Model model, Authentication authentication){
    	
    	 if (authentication != null && authentication.isAuthenticated()) {
             model.addAttribute("authenticated", true);
         } else {
             model.addAttribute("authenticated", false);
         }
    	return "home";
    }
    
    
    
    

}
