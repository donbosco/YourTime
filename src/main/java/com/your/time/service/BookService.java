package com.your.time.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.your.time.bean.Booking;
import com.your.time.dao.BookRepositoryDAO;
import com.your.time.dao.CommonDAO;
import com.your.time.util.BookingStatus;
import com.your.time.util.MongodbMapperUtil;

@Component
public class BookService {

    @Resource
    private BookRepositoryDAO bookRepositoryDAO;
    
    @Resource
	private CommonDAO commonDAO;
    
    private static final Logger logger = Logger.getLogger(BookService.class);
    
    public Booking save(Booking booking){
    	return bookRepositoryDAO.save(booking);
    }

	public Booking viewAppointmentDetailsById(Booking booking) {
		return bookRepositoryDAO.findOne(booking.get_id());
	}

	public List<Booking> getAllAppointmentsByConsumer(Booking booking) {
		Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.username).is(booking.getUsername()));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		for (Booking obj : list) {
			obj.getWaitTime();
		}
		return list;
	}
	
	public List<Booking> getAllActiveAppointmentByConsumer(Booking booking) {
		Query query = new Query();
		List<BookingStatus> statuses = new ArrayList<>();
		statuses.add(BookingStatus.NEW);
		statuses.add(BookingStatus.BOOKED);
		statuses.add(BookingStatus.CONFIRMED);
		statuses.add(BookingStatus.RESCHEDULED);
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.username).is(booking.getUsername()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		for (Booking obj : list) {
			obj.getWaitTime();
		}
		return list;
	}

	public Booking cancelAppointmentByConsumer(Booking booking) {
		booking.setStatus(BookingStatus.CANCEL.name());
		return bookRepositoryDAO.save(booking);
	}

	public Booking rescheduleAppointmentByConsumer(Booking booking) {
		booking.setStatus(BookingStatus.RESCHEDULED.name());
		return bookRepositoryDAO.save(booking);
	}
	/**
	 * ISP Specific Methods start
	 */
	public Booking viewScheduleDetailsById(Booking booking) {
		return bookRepositoryDAO.findOne(booking.get_id());
	}

	public List<Booking> getAllSchedulesByISP(Booking booking) {
		Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Booking> getAllActiveSchedulesByISP(Booking booking) {
		Query query = new Query();
		List<BookingStatus> statuses = new ArrayList<>();
		statuses.add(BookingStatus.CONFIRMED);
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Booking> getAllSchedulesDoneByISP(Booking booking) {
		Query query = new Query();
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.createdBy).in(booking.getServiceProviderId())));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Booking> getAllActiveSchedulesDoneByISP(Booking booking) {
		Query query = new Query();
		List<BookingStatus> statuses = new ArrayList<>();
		statuses.add(BookingStatus.NEW);
		statuses.add(BookingStatus.BOOKED);
		statuses.add(BookingStatus.CONFIRMED);
		statuses.add(BookingStatus.RESCHEDULED);
		query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)).andOperator(Criteria.where(MongodbMapperUtil.Booking.createdBy).in(booking.getServiceProviderId())));
		List<Booking> list  = commonDAO.findByQuery(query, Booking.class);
		return list;
	}

	public Booking cancelScheduleByISP(Booking booking) {
		booking.setStatus(BookingStatus.CANCEL.name());
		return bookRepositoryDAO.save(booking);
	}
	
	public Booking confirmScheduleByISP(Booking booking) {
		booking.setStatus(BookingStatus.CONFIRMED.name());
		return bookRepositoryDAO.save(booking);
	}

	public Booking rescheduleScheduleByISP(Booking booking) {
		booking.setStatus(BookingStatus.RESCHEDULED.name());
		return bookRepositoryDAO.save(booking);
	}
	
}