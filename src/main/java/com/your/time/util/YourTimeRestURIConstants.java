package com.your.time.util;
public class YourTimeRestURIConstants {

	public static class UsersWS{
		public static final String WS_AUTHENDICATE = "/users/authendicate";
		public static final String WS_SERVICE_TYPE_FETCH = "/users/serviceTypes";
		public static final String WS_HOME = "/users/all";
		public static final String WS_SIGN_UP = "/users/signup";
		public static final String DELETE_EMP = "/users/emp/delete/{id}";
	}
	
	public static class StaticWS{
		public static final String WS_FETCH_ACTIVE_TYPE = "/static/fetchActiveType";
		public static final String WS_SERVICE_TYPE_FETCH = "/users/serviceTypes";
		public static final String WS_HOME = "/static/all";
		public static final String WS_SIGN_UP = "/static/signup";
		public static final String DELETE_EMP = "/static/emp/delete/{id}";
	}
}