package com.mangesh.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangesh.fomobject.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer> {
	public List<Product> findAllByCategoryId(Integer id);
	public Product findByProductName(String productName);

}
