package com.your.time.dao;

import org.springframework.data.repository.CrudRepository;

import com.your.time.bean.Booking;

public interface BookRepositoryDAO extends CrudRepository<Booking,String>{
	
	Booking findByUsername(String username);
}