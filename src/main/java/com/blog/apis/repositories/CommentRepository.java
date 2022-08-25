package com.blog.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer >{

}
