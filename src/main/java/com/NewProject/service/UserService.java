package com.NewProject.service;

import java.util.List;

import com.NewProject.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getSingleUser(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
}
