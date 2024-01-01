package com.NewProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NewProject.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
