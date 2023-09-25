package com.mangesh.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mangesh.fomobject.Category;
import com.mangesh.food.dto.ProductDTO;
import com.mangesh.service.IAdminServices;




@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	
  private final	String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	
	@Autowired
	private IAdminServices services;
	
	
	@GetMapping(value = "/categories")
	public String getCat(Model model) {
		
		model.addAttribute("categories" , services.getAllCategories());
		
		return "categories";
	}
		
	@GetMapping(value = "/categories/add")
	public String getCategoriesAdd(Model model) {
		model.addAttribute("category" , new Category());
		return "categoriesAdd";
	}
	
	@PostMapping(value = "/categories/add")
	public String postCategoriesAdd(@ModelAttribute("category") Category category) {
		services.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping(value = "/categories/delete/{id}")
	public String deleteCategory(@PathVariable Integer id) {
		services.deleteCategory(id);
		return "redirect:/admin/categories";
		
	}
	
	@GetMapping(value = "/categories/update/{id}")
	public String updateCat(@PathVariable Integer id , Model model) {
		Optional<Category> optional = services.getCategoryById(id);
		model.addAttribute("category", optional.get());
		return "categoriesAdd";		
	}
	
	
	@GetMapping(value = "/products")
	public String getProducts(Model model) {
		model.addAttribute("products" , services.getAllProducts());
		return "products";
	}
	
	@GetMapping(value = "/products/add")
	public String postProductsAdd(Model model) {
		model.addAttribute("productDTO" , new ProductDTO());
		model.addAttribute("categories" , services.getAllCategories());
		return "productsAdd";
	}
	
	@PostMapping(value = "/products/add")
	public String postProductsAdd(@ModelAttribute("productDTO") ProductDTO productDto,
			                      @RequestParam("productImage")MultipartFile file,
			                      @RequestParam("imgName") String imgName) throws IOException {
		
		
		String imgUUID;
		
	
		
		if(!file.isEmpty()) {
			imgUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imgUUID);
			Files.write(fileNameAndPath, file.getBytes()); 
		}else {
			imgUUID = imgName;
		}
		
		productDto.setImageName(imgUUID);
		
		services.addProduct(productDto);
		return "redirect:/admin/products";
	}
	
	@GetMapping(value = "/product/delete/{id}")
	public String removeProductByid(@PathVariable Integer id){
		
		services.removeProductById(id);
		
		return "redirect:/admin/products";
		
	}
	
	@GetMapping(value = "/product/update/{id}")
	public String updateProductByid(@PathVariable Integer id , Model model){
		model.addAttribute("productDTO" , services.getProductById(id));
		model.addAttribute("categories" , services.getAllCategories());
		return "productsAdd";
		
	}
	
	
	@GetMapping(value = "/logout")
	public String getLogout(){		
		return "logout";
		
	}
	
	
	
	
	

}
