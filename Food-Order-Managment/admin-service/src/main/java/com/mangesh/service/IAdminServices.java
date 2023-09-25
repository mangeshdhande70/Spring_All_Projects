package com.mangesh.service;


import java.util.List;
import java.util.Optional;

import com.mangesh.fomobject.Category;
import com.mangesh.fomobject.Product;
import com.mangesh.food.dto.ProductDTO;


public interface IAdminServices {
	
	public Category addCategory(Category category);
	
	public List<Category> getAllCategories();
	
	public void deleteCategory(Integer id);
	
	public Optional<Category> getCategoryById(Integer id);
	
	
	public ProductDTO addProduct(ProductDTO productDTO);
	
	public List<Product> getAllProducts();
	
	public void removeProductById(Integer id);
	
	public ProductDTO getProductById(Integer id);

}
