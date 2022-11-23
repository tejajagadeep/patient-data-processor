package com.cts.patientdataprocessorbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

@Table(name = "UserEmp")
@Entity
public class User {

	@Id
	@Email(message = "enter valid email address")
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
