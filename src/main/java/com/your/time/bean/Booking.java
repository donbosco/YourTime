package com.your.time.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.your.time.util.MongodbMapperUtil;
import com.your.time.util.YourTimeUtil;

@Document(collection=MongodbMapperUtil.Collections.BOOKING)
public class Booking implements Serializable{
	@Id
	protected String _id;
	protected String username;
	@Transient
    protected User userDetail;
	protected String serviceProviderId;
	@Transient
	protected String service;
    protected String phonenumber;
	protected String date;
	protected String time;
	protected String reason;
	protected String status;
	@Transient
	protected String waitTime;

    public Booking() {}

    public Booking(String _id, String username, User userDetail, String serviceProviderId, String service, String phonenumber, String date, String time, String status) {
        this._id = _id;
        this.username = username;
        this.userDetail = userDetail;
        this.serviceProviderId = serviceProviderId;
        this.service = service;
        this.phonenumber = phonenumber;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Booking(String _id, String username, String serviceProviderId, String date, String time, String status) {
		this._id = _id;
		this.username = username;
		this.serviceProviderId = serviceProviderId;
		this.date = date;
		this.time = time;
		this.status = status;
		if(date != null && time != null)
			this.waitTime = YourTimeUtil.calculateWaitTime(date+" "+time);
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

	public String getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
		if(date != null && time != null)
			waitTime = YourTimeUtil.calculateWaitTime(date+" "+time);
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWaitTime() {
		if(date != null && time != null)
			waitTime = YourTimeUtil.calculateWaitTime(date+" "+time);
		return waitTime;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

    public User getUserDetail() { return userDetail; }

    public void setUserDetail(User userDetail) { this.userDetail = userDetail; }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}