package com.mangesh.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mangesh.food.dao.ICategoryDao;
import com.mangesh.food.dao.IProductDao;

@Component
public class DataUtils {
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private IProductDao productDao;
	
	
	

}
