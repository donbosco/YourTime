package com.your.time.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.your.time.bean.MasterData;
import com.your.time.dao.CommonDAO;
import com.your.time.dao.MasterDataDAO;
import com.your.time.util.MongodbMapperUtil;

@Component
public class MasterDataService {

    @Resource
    private MasterDataDAO masterDataDAO;
    
    @Resource
	private CommonDAO commonDAO;
    
    private static final Logger logger = Logger.getLogger(MasterDataService.class);
    
    public List<MasterData> findByActiveType(String type){
    	Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.MasterData.isActive).is("1").andOperator(Criteria.where(MongodbMapperUtil.MasterData.type).is(type)));
		List<MasterData> list  = commonDAO.findByQuery(query, MasterData.class);
		return list;
    }
}