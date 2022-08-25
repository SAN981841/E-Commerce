package com.blog.apis.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entity.Category;
import com.blog.apis.exception.ResourceNotFoundException;
import com.blog.apis.payload.CategoryDto;
import com.blog.apis.repositories.CategoryRepository;
import com.blog.apis.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addcategory = this.categoryRepository.save(cat);
		return this.modelMapper.map(addcategory, CategoryDto.class);
	}

	@Override
	public CategoryDto categoryUpdate(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

		this.categoryRepository.delete(cat);

	}

}
