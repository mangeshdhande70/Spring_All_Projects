package com.mangesh.service;


import java.util.ArrayList;
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
public class UserServiceImpl implements IUserServices {
	
	@Autowired
	private ICategoryDao categoryRepo;
	
	@Autowired
	private IProductDao productRepo;
	
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> list = productRepo.findAll();
		List<ProductDTO> productDtos = new ArrayList<>();
		list.forEach(products -> {
			ProductDTO productDto = ProductDTO.toDTO(products);;
			productDtos.add(productDto);
		});
		return productDtos;
	}

	@Override
	public List<ProductDTO> getProductByCategoryId(Integer id) {
		
		List<Product> list = productRepo.findAllByCategoryId(id);
        List<	ProductDTO> productDtos = new ArrayList<>();
		list.forEach(products -> {
			ProductDTO productDto = ProductDTO.toDTO(products);
			productDtos.add(productDto);
		});
		return productDtos;
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> optional = productRepo.findById(id);
		return optional.get();
	}

}
