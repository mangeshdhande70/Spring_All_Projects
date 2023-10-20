package com.mangesh.foodordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangesh.fomobject.Product;
import com.mangesh.food.dto.ProductDTO;
import com.mangesh.foodordermanagement.utils.DataUtils;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private DataUtils dataUtils;
	

	@Override
	public ProductDTO getProductDetailsByProductName(String productName) {
		Product product = dataUtils.getProductDetailsByProductName(productName);
		System.out.println("ProductServiceImpl.getProductDetailsByProductName()");
		System.out.println(product);
		return  product!=null?ProductDTO.toDTO(product):null;
	}

	
//	@Override
//	public List<Category> getAllCategories() {
//		return categoryRepo.findAll();
//	}
//
//	@Override
//	public List<ProductDTO> getAllProducts() {
//
//		List<Product> list = productRepo.findAll();
//
//		List<ProductDto> productDtos = new ArrayList<>();
//
//		list.forEach(productsList -> {
//			ProductDto productDto = mapper.map(productsList, ProductDto.class);
//			productDtos.add(productDto);
//		});
//
//		return productDtos;
//	}
//
//	@Override
//	public List<ProductDTO> getProductByCategoryId(Integer id) {
//
//		List<Product> list = productRepo.findAllByCategoryId(id);
//
//		List<ProductDto> productDtos = new ArrayList<>();
//
//		list.forEach(productsList -> {
//			ProductDto productDto = mapper.map(productsList, ProductDto.class);
//			productDtos.add(productDto);
//		});
//		return productDtos;
//	}
//
//	@Override
//	public ProductDTO getProductById(Integer id) {
//
//		Optional<Product> optional = productRepo.findById(id);
//
//		return optional.get();
//	}

	
}
