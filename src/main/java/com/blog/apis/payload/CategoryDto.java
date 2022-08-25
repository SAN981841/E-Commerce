package com.blog.apis.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Integer categoryId;
	@NotBlank
	@Size(min = 4, message = "Minimum Size of Category title is 4")
	private String categoryTitle;
	@NotBlank
	@Size(max = 10, message = "Minimum Size of Category Description is 10")
	private String categoryDescription;

}
