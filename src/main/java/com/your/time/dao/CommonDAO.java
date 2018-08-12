package com.your.time.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CommonDAO {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public <T> List<T> findByQuery(Query query,Class<T> t){
		return  mongoTemplate.find(query, t);
	}
	
	public <T> T findOneByQuery(Query query,Class<T> t){
		return  mongoTemplate.findOne(query, t);
	}
}
