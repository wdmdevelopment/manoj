package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_id")
	private long id;

//	@Column(name = "USER_FIRSTNAME")
//	private String fname;
//
//	@Column(name = "USER_LASTNAME")
//	private String lname;
	
	private String userName;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_MOBILE_NUMBER")
	private String mobile;

	@Column(name = "USER_ROLE")
	private String role;

	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


//	public String getFname() {
//		return fname;
//	}
//
//
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
//
//	
//	public String getLname() {
//		return lname;
//	}
//
//	
//	public void setLname(String lname) {
//		this.lname = lname;
//	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}


//	public String getPass() {
//		return pass;
//	}
//
//	
//	public void setPass(String pass) {
//		this.pass = pass;
//	}


	public String getMobile() {
		return mobile;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public String getRole() {
		return role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public User(long id, String userName, String email, String password, String mobile, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
	}


	public User(String userName, String email, String password) {
		
		this.userName = userName;
		this.email = email;
		this.password = password;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}




	




}
