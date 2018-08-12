package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.bean.Status;
import com.your.time.bean.User;
import com.your.time.dao.CommonDAO;
import com.your.time.service.UserService;
import com.your.time.util.MongodbMapperUtil;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class UsersController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonDAO commonDAO;
	
	@RequestMapping(value=YourTimeRestURIConstants.UsersWS.WS_HOME, method = RequestMethod.GET)
	public Status<User> findAll() {
		Status<User> status = new Status<User>();
		List<User> users = (List<User>) userService.findAll();
		if(users == null || users.size() == 0){
			status.setStatus(false);
			status.setMessage("No users available");
		}else{
			status.setStatus(true);
			status.setResults(users);
			status.setMessage("Authendication is successful");
		}
		return status;
	}
	
	@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_AUTHENDICATE, method = RequestMethod.POST)
	public Status<User>  authendicate(@RequestBody User user) {
		Status<User> status = new Status<User>();
		
		Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.User.username).is(user.getUsername()).andOperator(Criteria.where(MongodbMapperUtil.User.password).is(user.getPassword())));
		User resultedUser = commonDAO.findOneByQuery(query, User.class);
		if(resultedUser == null){
			status.setStatus(false);
			status.setResult(user);
			status.setMessage("Either Username or Password is incorrect");
		}else{
			status.setStatus(true);
			status.setResult(resultedUser);
			status.setMessage("Authendication is successful");
		}
		return status;
	}
	
	@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_SIGN_UP, method = RequestMethod.POST)
	public Status<User> registerCompany(@RequestBody User user) {
		Status<User> status = new Status<User>();
		user.setServiceProvider(user.getServiceProviderTye() == null || user.getServiceProviderTye().isEmpty());
		user = userService.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Registration is successful");
			status.setResult(user);
		}else{
			status.setStatus(false);
			status.setMessage("Registration is not successful");
			status.setResult(user);
		}
		return status;
	}
	
	/*@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_SIGN_UP, method = RequestMethod.POST)
	public @ResponseBody Status<User> updateProfile(@RequestBody User user) {
		Status<User> status = new Status<User>();
		user.setServiceProvider(user.getServiceProviderTye() == null || user.getServiceProviderTye().isEmpty());
		user = userService.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Your profile is updated");
			status.setResult(user);
		}else{
			status.setStatus(false);
			status.setMessage("Your profile could not be updated.");
			status.setResult(user);
		}
		return status;
	}*/
}