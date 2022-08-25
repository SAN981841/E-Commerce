package com.blog.apis.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;

	private String password;

}
