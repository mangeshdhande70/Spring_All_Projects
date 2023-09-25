package com.ineuron.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ineuron.model.User;
import com.ineuron.service.UserService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String getHomePage(Model model, Authentication authentication) {

		if (authentication != null && authentication.isAuthenticated()) {
			model.addAttribute("authenticated", true);
		} else {
			model.addAttribute("authenticated", false);
		}
		return "home";
	}

	@GetMapping(value = "/public")
	public String get() {
		return "Welcome message";
	}

	@PostMapping(value = "/create")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping(value = "/getCurrentUser")
	public String getCurrentUserName(Principal principal) {
		return principal.getName();
	}

}
