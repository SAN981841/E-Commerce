package com.blog.apis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entity.Comment;
import com.blog.apis.entity.Post;
import com.blog.apis.exception.ResourceNotFoundException;
import com.blog.apis.payload.CommentDto;
import com.blog.apis.repositories.CommentRepository;
import com.blog.apis.repositories.PostRepository;
import com.blog.apis.services.CommentService;
@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepository.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com=this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
		this.commentRepository.delete(com);

	}

}
