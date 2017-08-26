package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.bean.Booking;
import com.your.time.bean.Status;
import com.your.time.dao.CommonDAO;
import com.your.time.service.BookService;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class BookingController {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private BookService bookService;

	@Autowired
	private CommonDAO commonDAO;

	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_BOOK_APPOINTMENT, method = RequestMethod.POST)
	public Status<Booking> bookAppointment(@RequestBody Booking booking) {
		Booking appointment = bookService.save(booking);
		Status<Booking> status = new Status<Booking>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is successful");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be succeeded.");
			status.setResult(booking);
		}
		return status;
	}
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_VIEW_APPOINTMENT_DETAILS, method = RequestMethod.POST)
	public Status<Booking> viewAppointmentDetailsById(@RequestBody Booking booking) {
		Booking appointment = bookService.viewAppointmentDetailsById(booking);
		Status<Booking> status = new Status<Booking>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointments are loaded");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_APPOINTMENTS_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Booking> getAllAppointmentsByConsumer(@RequestBody Booking booking) {
		List<Booking> appointments = bookService.getAllAppointmentsByConsumer(booking);
		Status<Booking> status = new Status<Booking>();
		if(appointments != null && appointments.size() > 0){
			status.setStatus(true);
			status.setMessage("Appointments are loaded");
			status.setResults(appointments);
		}else{
			status.setStatus(false);
			status.setMessage("Appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_APPOINTMENTS_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Booking> getAllActiveAppointmentByConsumer(@RequestBody Booking booking) {
		List<Booking> appointments = bookService.getAllActiveAppointmentByConsumer(booking);
		Status<Booking> status = new Status<Booking>();
		if(appointments != null && appointments.size() > 0){
			status.setStatus(true);
			status.setMessage("Your appointments are loaded");
			status.setResults(appointments);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_APPOINTMENT_CANCEL_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Booking> cancelAppointmentByConsumer(@RequestBody Booking booking) {
		Booking appointment = bookService.cancelAppointmentByConsumer(booking);
		Status<Booking> status = new Status<Booking>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is cancelled.");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_APPOINTMENT_RESCHEDULE_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Booking> rescheduleAppointmentByConsumer(@RequestBody Booking booking) {
		Booking appointment = bookService.rescheduleAppointmentByConsumer(booking);
		Status<Booking> status = new Status<Booking>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is rescheduled");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be rescheduled.");
			status.setResult(booking);
		}
		return status;
	}
	
	/**
	 * ISP Specific Start
	 */
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_CREATE_SCHEDULE_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> createScheduleByISP(@RequestBody Booking booking) {
		Booking schedule = bookService.save(booking);
		Status<Booking> status = new Status<Booking>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is created.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be created.");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_VIEW_SCHEDULE_DETAILS_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> viewScheduleDetailsById(@RequestBody Booking booking) {
		Booking schedule = bookService.viewScheduleDetailsById(booking);
		Status<Booking> status = new Status<Booking>();
		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule details are loaded");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_SCHEDULES_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> getAllSchedulesByISP(@RequestBody Booking booking) {
		List<Booking> schedules = bookService.getAllSchedulesByISP(booking);
		Status<Booking> status = new Status<Booking>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_SCHEDULES_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> getAllActiveSchedulesByISP(@RequestBody Booking booking) {
		List<Booking> schedules = bookService.getAllActiveSchedulesByISP(booking);
		Status<Booking> status = new Status<Booking>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_SCHEDULES_DONE_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> getAllSchedulesDoneByISP(@RequestBody Booking booking) {
		List<Booking> schedules = bookService.getAllSchedulesDoneByISP(booking);
		Status<Booking> status = new Status<Booking>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_SCHEDULES_DONE_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> getAllActiveSchedulesDoneByISP(@RequestBody Booking booking) {
		List<Booking> schedules = bookService.getAllActiveSchedulesDoneByISP(booking);
		Status<Booking> status = new Status<Booking>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_CANCEL_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> cancelScheduleByISP(@RequestBody Booking booking) {
		Booking schedule = bookService.cancelScheduleByISP(booking);
		Status<Booking> status = new Status<Booking>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is cancelled.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_CONFIRM_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> confirmScheduleByISP(@RequestBody Booking booking) {
		Booking schedule = bookService.confirmScheduleByISP(booking);
		Status<Booking> status = new Status<Booking>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is confirmed.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be confirmed.");
			status.setResult(booking);
		}
		return status;
	}

	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_RESCHEDULE_BY_ISP, method = RequestMethod.POST)
	public Status<Booking> rescheduleScheduleByISP(@RequestBody Booking booking) {
		Booking schedule = bookService.rescheduleScheduleByISP(booking);
		Status<Booking> status = new Status<Booking>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is cancelled.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
}