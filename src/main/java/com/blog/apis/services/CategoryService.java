package com.blog.apis.services;

import java.util.List;

import com.blog.apis.payload.CategoryDto;

public interface CategoryService {
	// Post
	CategoryDto createCategory(CategoryDto categoryDto);

	// Put
	CategoryDto categoryUpdate(CategoryDto categoryDto, Integer categoryId);

	// GetById
	CategoryDto getCategory(Integer categoryId);

	// GetAll
	List<CategoryDto> getAllCategory();

	// Delete
	void deleteCategory(Integer categoryId);

}