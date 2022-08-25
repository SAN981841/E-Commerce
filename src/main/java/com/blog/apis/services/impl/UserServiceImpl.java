package com.blog.apis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.apis.config.AppConstants;
import com.blog.apis.entity.Role;
import com.blog.apis.entity.User;
import com.blog.apis.exception.ResourceNotFoundException;
import com.blog.apis.payload.UserDto;
import com.blog.apis.repositories.RoleRepository;
import com.blog.apis.repositories.UserRepository;
import com.blog.apis.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDto createUser(UserDto usDto) {
		User user = this.dtoToUser(usDto);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto userUpdate(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepository.save(user);
		UserDto userToDto1 = this.userToDto(updatedUser);
		return userToDto1;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);

	}

	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		return user;
	}

	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		/*
		 * userDto.setId(user.getId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setPassword(user.getEmail());
		 * userDto.setAbout(user.getAbout());
		 */
		return userDto;

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		//encode the password 
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		//roles
		Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepository.save(user);
			
		return this.modelMapper.map(newUser, UserDto.class);
	}

}
