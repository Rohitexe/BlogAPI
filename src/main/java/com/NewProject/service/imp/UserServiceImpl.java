package com.NewProject.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewProject.entities.User;
import com.NewProject.exceptions.ResourceNotFoundException;
import com.NewProject.payload.UserDto;
import com.NewProject.repositories.UserRepo;
import com.NewProject.service.UserService;

@Service 
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	//create User 
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}
	@Override
	//update User 
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userToDto1 = this.userToDto(updatedUser);
		
		return userToDto1;
	}
	
	
	
	//Get User By ID
	@Override
	public UserDto getSingleUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
		
	}
//	public UserDto getById(Integer userId) {
//			User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
//		return this.userToDto(user);
//	}
	
	@Override
	//Get All User 
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	
		@Override
		//delete  User 
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId ));
		this.userRepo.delete(user);
		
	}
	
	private User dtoToUser(UserDto userDto) {
	User user = this.modelMapper.map(userDto, User.class); //after Model Mapper
	
	//before add Model Mapper
//	user.setId(userDto.getId());
//	user.setName(userDto.getName());
//	user.setEmail(userDto.getEmail());
//	user.setPassword(userDto.getPassword());
//	user.setAbout(userDto.getAbout());
	return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		//before add Model Mapper
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());	
//		userDto.setAbout(user.getAbout());
		return userDto;
		}
	

	
	
}
