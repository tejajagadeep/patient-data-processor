package com.cts.patientdataprocessordoctor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Doctor {

	@Id
	private String emailId;
	
	@NotEmpty
	@NotNull
	private String password;
	
	@NotEmpty
	@NotNull
	private String firstName;
	
	@NotEmpty
	@NotNull
	private String lastName;
	
	@NotEmpty
	@NotNull
	private Date dateOfBirth;
	
	@NotEmpty
	@NotNull
	private String gender;
	
	@NotEmpty
	@NotNull
	private String address;
	
	@NotEmpty
	@NotNull
	private Long contactNumber;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Doctor() {
		super();
	}
	
	
}
