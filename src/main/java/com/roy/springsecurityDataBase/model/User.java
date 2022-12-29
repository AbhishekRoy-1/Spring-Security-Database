package com.roy.springsecurityDataBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userId; 		//Auto-Generated and should be a primary Key
	private String userName;
	private String password;
	private String emailId;
	public User(int userId, String userName, String password, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
	}
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
