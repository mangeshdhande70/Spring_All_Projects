package com.mangesh.foodordermanagement.service;

import com.mangesh.food.dto.ProductDTO;

public interface IProductService {
	
	public ProductDTO getProductDetailsByProductName(String productName);
//	public List<Category> getAllCategories();
//	public List<ProductDTO> getProductByCategoryId(Integer id);
//	public ProductDTO getProductById(Integer id);

}
