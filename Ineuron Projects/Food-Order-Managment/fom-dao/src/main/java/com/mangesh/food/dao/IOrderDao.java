package com.mangesh.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangesh.fomobject.Order;
import java.util.List;

@Repository
public interface IOrderDao extends JpaRepository<Order, Long> {
    
//	public List<Order> findByActive(boolean active);
//    public List<Order> findByDeliverd(boolean deliverd);
    
    List<Order> findByIsDeliverd(boolean isDelivered);
    List<Order> findByIsActive(boolean isActive);
    
	
}
