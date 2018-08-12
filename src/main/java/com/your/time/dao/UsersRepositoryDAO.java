package com.your.time.dao;

import org.springframework.data.repository.CrudRepository;

import com.your.time.bean.User;

public interface UsersRepositoryDAO extends CrudRepository<User,String>{
	
	User findByUsername(String username);
}