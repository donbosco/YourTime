package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.your.time.bean.Status;
import com.your.time.bean.User;
import com.your.time.dao.CommonDAO;
import com.your.time.dao.UsersRepositoryDAO;
import com.your.time.util.MongodbMapperUtil;


@RestController
public class UsersController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UsersRepositoryDAO userRepository;
	
	@Autowired
	private CommonDAO commonDAO;
	
	@RequestMapping("/users")
	public ModelAndView findAll() {
		List<User> users = (List<User>) userRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("users", users );
		return modelAndView;
	}
	
	@RequestMapping(value = "/users/authendicate/{name}/{password}")
	public Status authendicate(@PathVariable String name,@PathVariable String password) {
		Status status = new Status();
		
		Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.Attributes.USERNAME).is(name).andOperator(Criteria.where(MongodbMapperUtil.Attributes.PASSWORD).is(password)));
		User user = commonDAO.findOneByQuery(query, User.class);
		if(user == null){
			status.setStatus(false);
			status.setMessage("Either Username or Password is incorrect");
		}else{
			status.setStatus(true);
			status.setMessage("Authendication is successful");
		}
		return status;
	}
	
	@RequestMapping(value = "/users/registerCompany")
	public Status registerCompany(@PathVariable User user) {
		Status status = new Status();
		user = userRepository.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Company registration is successful");
		}else{
			status.setStatus(false);
			status.setMessage("Company registration is not successful");
		}
		return status;
	}
	
	@RequestMapping(value = "/users/registerUser")
	public Status registerUser(@PathVariable User user) {
		Status status = new Status();
		user = userRepository.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("User registration is successful");
		}else{
			status.setStatus(false);
			status.setMessage("User registration is not successful");
		}
		return status;
	}
}