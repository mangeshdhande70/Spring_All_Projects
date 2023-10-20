package com.mangesh.foodordermanagement.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mangesh.fomobject.Order;
import com.mangesh.fomobject.Product;
import com.mangesh.fomobject.User;
import com.mangesh.food.dao.IOrderDao;
import com.mangesh.food.dao.IProductDao;
import com.mangesh.food.dao.IUserDao;

@Component
public class DataUtils {

	@Autowired
	private IOrderDao orderDao;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IProductDao productDao;
	
	
//	@Autowired
//	private ICategoryDao categoryDao;

	public boolean addUpdateUser(User user) {
		User response = userDao.save(user);
		return response != null ? true : false;
	}

	public Optional<User> getUserById(Long userId) {
		return userDao.findById(userId);	
	}

	public boolean createUpdateOrder(Order order) {
		Order response = orderDao.save(order);
		return response != null ? true : false;
	}

	public Optional<Order> getOrderById(Long orderId) {
		return orderDao.findById(orderId);
	}
	
	
	public Product getProductDetailsByProductName(String productName) {
		return productDao.findByProductName(productName);
	}
	
	
	public List<Order> getAllActiveOrder(){
		return orderDao.findByIsActive(true);
	}
	
}
