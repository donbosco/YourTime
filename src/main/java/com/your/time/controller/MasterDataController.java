package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.your.time.bean.MasterData;
import com.your.time.bean.Status;
import com.your.time.bean.User;
import com.your.time.dao.CommonDAO;
import com.your.time.dao.MasterDataDAO;
import com.your.time.dao.UsersRepositoryDAO;
import com.your.time.service.MasterDataService;
import com.your.time.util.MongodbMapperUtil;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class MasterDataController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value=YourTimeRestURIConstants.StaticWS.WS_HOME, method = RequestMethod.POST)
	public ModelAndView findAll() {
		//List<User> users = (List<User>) masterDataDAO.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		//modelAndView.addObject("users", users );
		return modelAndView;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.StaticWS.WS_FETCH_ANY_ACTIVE_TYPE, method = RequestMethod.POST)
	public Status<MasterData> getByActiveType(@RequestBody MasterData masterData) {
		Status<MasterData> status = new Status<MasterData>();
		List<MasterData> list  = masterDataService.findByActiveType(masterData.getType());
		if(list == null || list.isEmpty()){
			status.setStatus(false);
			status.setMessage("No service types configured.");
		}else{
			status.setStatus(true);
			status.setMessage("Loaded the service types");
			status.setResults(list);
		}
		return status;
	}
}