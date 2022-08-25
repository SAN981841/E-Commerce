	package com.blog.apis.services;

import java.util.List;

import com.blog.apis.entity.Post;
import com.blog.apis.payload.PostDto;
import com.blog.apis.payload.PostResponse;

public interface PostService {
	// Post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	// Update
	PostDto updatePost(PostDto postDto, Integer postId);

	// Delete
	void deletePost(Integer postId);

	// getAll Post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

	// get Single post
	PostDto getPostById(Integer postId);

	// get All post by category
	List<PostDto> getPostByCategory(Integer categoryId);

	// get All post by User
	List<PostDto> getPostByUser(Integer userId);

	// get All posts
	List<PostDto> searchPosts(String keyword);

}
