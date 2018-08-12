/**
 * 
 */
package com.your.time.util;

/**
 * @author boscosiva
 *
 */
public class MongodbMapperUtil {
	/*public static class Attributes{
		public final static String USERNAME = "username";
		public final static String PASSWORD = "password";
		public final static String FIRSTNAME = "firstname";
		public final static String LASTNAME = "lastname";
		public final static String EMAIL = "email";
		public final static String ADDRESSLINE1 = "addressline1";
		public final static String ADDRESSLINE2 = "addressline2";
		public final static String COUNTRY = "country";
		public final static String STATE = "state";
		public final static String ZIP = "zip";
		public final static String PHONENUMBER = "phonenumber";
		public final static String TYPE = "type";
		public static String ISACTIVE = "isactive";
	}*/
	
	public static class User{
		public static String _id = "_id";
		public static String username = "username";
		public static String password = "password";
		public static String confirmPassword = "confirmPassword";
		public static String firstname = "firstname";
		public static String lastname = "lastname";
		public static String email = "email";
		public static String addressline1 = "addressline1";
		public static String addressline2 = "addressline2";
		public static String country = "country";
		public static String state = "state";
		public static String zip = "zip";
		public static String phonenumber = "phonenumber";
		public static String isServiceProvider = "isServiceProvider";
		public static String role = "role";
		public static String serviceProviderId = "serviceProviderId";
	}
	
	public static class ServiceProvider{
		public static String _id = "_id";
	    public static String username = "username";
	    public static String ispId = "ispId";
	    public static String displayName = "displayName";
	    public static String OfficialName = "OfficialName";
	    public static String email = "email";
	    public static String addressline1 = "addressline1";
	    public static String addressline2 = "addressline2";
	    public static String country = "country";
	    public static String state = "state";
	    public static String zip = "zip";
	    public static String phonenumber = "phonenumber";
	    public static String serviceProviderTye = "serviceProviderTye";
	}
	
	public static class MasterData{
		public static String _id = "_id";
		public static String type = "type";
		public static String code = "code";
		public static String value = "value";
		public static String isActive = "isActive";
		public static String order = "order";
	}
	
	public static class Booking{
		public static String _id = "_id";
		public static String username = "username";
		public static String serviceProviderId = "serviceProviderId";
		public static String service = "service";
	    public static String phonenumber = "phonenumber";
		public static String date = "date";
		public static String time = "time";
		public static String status = "status";
		public static String waitTime = "waitTime";
		public static String createdBy = "createdBy";
	}
	
	public static class Cancelation{
		
	}
	
	public static class Collections{
		public final static String BOOKING = "booking";
		public final static String CANCELATION = "cancelation";
		public final static String FEEDBACK = "feedback";
		public final static String MASTERDATA = "masterdata";
		public final static String SERVICEPROVIDER = "serviceprovider";
		public final static String USER = "user";
	}
}
