package com.mangesh.controller;
//package com.food.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.food.services.IUserServices;
//
//@Controller
//@RequestMapping(value = "/user")
//public class UserController {
//	
//	@Autowired
//	private IUserServices services;
//
//	
//	@GetMapping(value = {"/" , "/home"})
//	public String getHomePage() {
//		return "index";
//	}
//	
//	
//	@GetMapping(value = "/shop")
//	public String getShop(Model model) {
//		
//		model.addAttribute("categories", services.getAllCategories());
//		model.addAttribute("products", services.getAllProducts());
//		
//		return "shop";
//		
//	}
//	
//	
//	@GetMapping(value = "/shop/viewproduct/{id}")
//	public String getViewProduct(@PathVariable Integer id , Model model) {
//		model.addAttribute("categories", services.getAllCategories());
//		model.addAttribute("product", services.getProductById(id));
//		return "viewProduct";
//		
//	}
//	
//	@GetMapping(value = "/shop/category/{id}")
//	public String getProductsByCategory(@PathVariable Integer id , Model model) {
//		model.addAttribute("categories", services.getAllCategories());
//		model.addAttribute("products", services.getProductByCategoryId(id));
//		
//		return "shop";	
//	}
//	
//	
//
//}
