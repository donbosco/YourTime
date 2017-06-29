package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.your.time.bean.Status;
import com.your.time.bean.User;
import com.your.time.dao.CommonDAO;
import com.your.time.service.UserService;
import com.your.time.util.MongodbMapperUtil;
import com.your.time.util.YourTimeRestURIConstants;


//@RestController
//@RequestMapping("/users")
@Controller
public class UsersController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonDAO commonDAO;
	
	@RequestMapping(value=YourTimeRestURIConstants.UsersWS.WS_HOME, method = RequestMethod.POST)
	public ModelAndView findAll() {
		List<User> users = (List<User>) userService.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("users", users );
		return modelAndView;
	}
	
	@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_AUTHENDICATE, method = RequestMethod.POST)
	public @ResponseBody Status<User>  authendicate(@RequestBody String name,@RequestBody String password) {
		Status<User> status = new Status<User>();
		
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
	
	@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_SIGN_UP, method = RequestMethod.POST)
	public @ResponseBody Status<User> registerCompany(@RequestBody User user) {
		Status<User> status = new Status<User>();
		user = userService.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Registration is successful");
		}else{
			status.setStatus(false);
			status.setMessage("Registration is not successful");
		}
		return null;
	}
}