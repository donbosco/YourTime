package com.your.time.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.your.time.bean.User;
import com.your.time.repository.UsersRepository;


@RestController
public class UsersController {
	
	@Autowired
	private UsersRepository repository;
	
	@RequestMapping("/users")
	public ModelAndView findAll() {
		List<User> users = repository.getAllObjects();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("users", users );
		return modelAndView;
	}
	
	@RequestMapping(value = "/users/{name}")
	public ModelAndView findUser(@PathVariable String name) {
		User user = repository.getObject(name);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("users", user );
		return modelAndView;
	}
	
	
	
}