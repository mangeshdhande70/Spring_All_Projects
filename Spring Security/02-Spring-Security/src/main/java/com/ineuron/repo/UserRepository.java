package com.ineuron.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ineuron.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public Optional<User> findByEmail(String email);

}
