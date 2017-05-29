package com.your.time.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.your.time.bean.User;
import com.your.time.util.MongodbMapperUtil;

public class UsersRepository implements Repository<User>{

	MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<User> getAllObjects() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public void saveObject(User user) {
		mongoTemplate.insert(user);
		
	}

	@Override
	public User getObject(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where(MongodbMapperUtil.Attributes.USERNAME).is(id)),User.class);
	}

	@Override
	public WriteResult updateObject(String id, String name) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where(MongodbMapperUtil.Attributes.USERNAME).is(name)),
				Update.update(MongodbMapperUtil.Attributes.USERNAME, name), User.class);
	}

	@Override
	public void deleteObject(String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
	}

	@Override
	public void createCollection() {
		if (!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
	}

	@Override
	public void dropCollection() {
		if (mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.dropCollection(User.class);
		}
	}
	
}