package com.mangesh.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangesh.fomobject.Category;


@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {
	
}
