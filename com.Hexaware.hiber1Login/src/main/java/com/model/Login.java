package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logintable")
public class Login {
	@Id
	String userId;
	@Column
	String userPass;
	@Column
	String email;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userId, String userPass, String email) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userPass=" + userPass + ", email=" + email + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
