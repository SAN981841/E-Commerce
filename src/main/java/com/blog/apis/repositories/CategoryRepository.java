package com.blog.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

}
