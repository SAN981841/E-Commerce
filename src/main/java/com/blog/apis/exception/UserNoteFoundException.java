package com.blog.apis.exception;

public class UserNoteFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	String fieldValue;
	public UserNoteFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	

}



