package com.mangesh.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangesh.fomobject.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

}
