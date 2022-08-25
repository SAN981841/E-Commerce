package com.blog.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entity.Category;
import com.blog.apis.entity.Post;
import com.blog.apis.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);

}
