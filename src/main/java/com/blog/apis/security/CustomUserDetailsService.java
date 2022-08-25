package com.blog.apis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.apis.entity.User;
import com.blog.apis.exception.ResourceNotFoundException;
import com.blog.apis.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by userName
		User user = this.userRepository.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
		return user;
	}

}
