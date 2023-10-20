package com.mangesh.service;


import java.util.List;

import com.mangesh.fomobject.Category;
import com.mangesh.fomobject.Product;
import com.mangesh.food.dto.ProductDTO;



public interface IUserServices {
	
	public List<Category> getAllCategories();
	
	public List<ProductDTO> getAllProducts();
	
	public Product getProductById(Integer id);
	
	public List<ProductDTO> getProductByCategoryId(Integer id);

}
