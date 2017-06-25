package com.your.time.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.your.time.bean.MasterData;

public interface MasterDataDAO extends CrudRepository<MasterData,String>{
	
	List<MasterData> findByType(String type);
}