package com.your.time.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.your.time.util.MongodbMapperUtil;

@Document(collection=MongodbMapperUtil.Collections.USER)
public class User  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    protected String _id;
    protected String username;
    protected String password;
    protected String confirmPassword;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String addressline1;
    protected String addressline2;
    protected String country;
    protected String state;
    protected String zip;
    protected String phonenumber;
    private boolean isServiceProvider;
    private String role;
    private String serviceProviderId;
    
    @Transient
    protected String serviceProviderTye;
    @Transient
    protected ServiceProvider serviceProviderDetail;
    
    public User() {}
    
	public User(String _id, String username, String password, String confirmPassword, String firstname, String lastname,
			String email, String addressline1, String addressline2, String country, String state, String zip,
			String phonenumber, boolean isServiceProvider, String role,String serviceProviderId) {
		super();
		this._id = _id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.phonenumber = phonenumber;
		this.isServiceProvider = isServiceProvider;
		this.role = role;
		this.serviceProviderId = serviceProviderId;
	}
	
	public User(String _id, String username, String password, String confirmPassword, String firstname, String lastname,
			String email, String addressline1, String addressline2, String country, String state, String zip,
			String phonenumber, boolean isServiceProvider, String role,ServiceProvider serviceProviderDetail,String serviceProviderId) {
		super();
		this._id = _id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.phonenumber = phonenumber;
		this.isServiceProvider = isServiceProvider;
		this.role = role;
		this.serviceProviderDetail = serviceProviderDetail;
		this.serviceProviderId = serviceProviderId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public boolean isServiceProvider() {
		return isServiceProvider;
	}

	public void setServiceProvider(boolean isServiceProvider) {
		this.isServiceProvider = isServiceProvider;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getServiceProviderTye() {
		return serviceProviderTye;
	}

	public void setServiceProviderTye(String serviceProviderTye) {
		this.serviceProviderTye = serviceProviderTye;
	}

	public ServiceProvider getServiceProviderDetail() {
		return serviceProviderDetail;
	}

	public void setServiceProviderDetail(ServiceProvider serviceProviderDetail) {
		this.serviceProviderDetail = serviceProviderDetail;
	}
	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public String getServiceProviderId() {
		return serviceProviderId;
	}
}