package com.blog.apis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	Optional<User> findByEmail(String email);

}
