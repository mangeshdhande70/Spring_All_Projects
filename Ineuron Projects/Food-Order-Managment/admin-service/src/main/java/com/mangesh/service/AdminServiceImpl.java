package com.mangesh.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangesh.fomobject.Category;
import com.mangesh.fomobject.Product;
import com.mangesh.food.dao.ICategoryDao;
import com.mangesh.food.dao.IProductDao;
import com.mangesh.food.dto.ProductDTO;

@Service
public class AdminServiceImpl implements IAdminServices{
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private IProductDao productDao;
	

	@Override
	public Category addCategory(Category category) {
		return  categoryDao.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryDao.deleteById(id);
	}

	@Override
	public Optional<Category> getCategoryById(Integer id) {
		return categoryDao.findById(id);
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
//		Product product2 = ProductDTO.toEntity(productDTO);
		Product product = productDao.save(ProductDTO.toEntity(productDTO));
		return ProductDTO.toDTO(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public void removeProductById(Integer id) {
		productDao.deleteById(id);
		
	}

	@Override
	public ProductDTO getProductById(Integer id) {
	
		Optional<Product> optional = productDao.findById(id);
		if (optional.isPresent()) {
			return  ProductDTO.toDTO(optional.get());
		}
		return null;
	}

}
