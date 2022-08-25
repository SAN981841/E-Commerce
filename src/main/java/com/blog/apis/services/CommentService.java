package com.blog.apis.services;

import com.blog.apis.payload.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId);

}
