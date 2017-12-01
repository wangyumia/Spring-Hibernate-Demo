package com.bear.bookonline.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="log")
public class Log {
	private int logid;
	private String name;
	private Date time;
	private User user;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLogId() {
		return logid;
	}
	public void setLogId(int logid) {
		this.logid = logid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@ManyToOne
	@JoinColumn(name="USERID")
	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
