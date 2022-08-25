package com.blog.apis.services;

import java.util.List;

import com.blog.apis.payload.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);

	UserDto userUpdate(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	void deleteUser(Integer userId);


}
