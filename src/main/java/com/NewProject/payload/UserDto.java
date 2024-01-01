package com.NewProject.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter


public class UserDto {

	
	private int id;
	@NotNull
	@Size(min = 4,message = "user must be min of 4 characters !! ")
	private String name;
	@Email(message = " Email address is not valid !!")
	private String email;
	@NotNull
	@Size(min =  3,max = 10,message = "Password must be min 3 chars and max of 10 chars !!")
	private String password;
	@NotNull
	private String about;
}
