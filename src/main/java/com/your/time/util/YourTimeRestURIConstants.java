package com.your.time.util;
public class YourTimeRestURIConstants {

	public static class UsersWS{
		public static final String WS_AUTHENDICATE = "/users/authendicate";
		public static final String WS_HOME = "/users/all";
		public static final String WS_SIGN_UP = "/users/signup";
		public static final String WS_UPDATE_USER_PROFILE = "/users/profile/update";
	}
	
	public static class StaticWS{
		public static final String WS_FETCH_ANY_TYPE = "/static/any";
		public static final String WS_FETCH_ANY_ACTIVE_TYPE = "/static/any/active";
	}
	
	public static class BookingWS{
		public static final String WS_BOOK_APPOINTMENT = "/book/consumer/appointment/create";
		public static final String WS_VIEW_APPOINTMENT_DETAILS = "/book/consumer/appointment/view";
		public static final String WS_ALL_APPOINTMENTS_BY_CONSUMER = "/book/consumer/appointment/list/all";
		public static final String WS_ALL_ACTIVE_APPOINTMENTS_BY_CONSUMER = "/book/consumer/appointment/list/active";
		public static final String WS_APPOINTMENT_CANCEL_BY_CONSUMER = "/book/consumer/appointment/cancel";
		public static final String WS_APPOINTMENT_RESCHEDULE_BY_CONSUMER = "/book/consumer/appointment/reschedule";
		
		public static final String WS_CREATE_SCHEDULE_BY_ISP = "/book/isp/schedule/create";
		public static final String WS_VIEW_SCHEDULE_DETAILS_BY_ISP = "/book/isp/schedule/view";
		public static final String WS_ALL_SCHEDULES_BY_ISP = "/book/isp/schedule/list/all";
		public static final String WS_ALL_ACTIVE_SCHEDULES_BY_ISP = "/book/isp/schedule/list/active";
		public static final String WS_ALL_SCHEDULES_DONE_BY_ISP = "/book/isp/schedule/list/isp";
		public static final String WS_ALL_ACTIVE_SCHEDULES_DONE_BY_ISP = "/book/isp/schedule/list/active/isp";
		public static final String WS_SCHEDULE_CANCEL_BY_ISP = "/book/isp/schedule/cancel";
		public static final String WS_SCHEDULE_RESCHEDULE_BY_ISP = "/book/isp/schedule/reschedule";
	}
}