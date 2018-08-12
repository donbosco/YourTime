package com.your.time.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.your.time.bean.ServiceProvider;

public interface ServiceProviderDAO extends CrudRepository<ServiceProvider,String>{
	
	ServiceProvider findByIspId(String ispId);
	
	List<ServiceProvider> findByServiceProviderTye(String serviceProviderType);
	
	ServiceProvider findByEmail(String ispId);
}