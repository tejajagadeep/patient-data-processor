package com.cts.authenticationmicroservice.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.datetime.DateFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne(cascade = {
//			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
//	})
//	@JoinColumn(name = "contact_number")
	private Long contactNumber;
	
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private Locale date;
	
	@Column(name="systolic")
	private int systolic;
	
	@Column(name="diastolic")
	private int diastolic;
	
	@Column(name="sugar_level")
	private int sugarlevel;
	
	@Column(name="sugar_level_2")
	private int sugarlevel2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Locale getDate(){
		return date;
	}

	public void setDate(Locale date) {
		this.date = date;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getSugarlevel() {
		return sugarlevel;
	}

	public void setSugarlevel(int sugarlevel) {
		this.sugarlevel = sugarlevel;
	}

	public int getSugarlevel2() {
		return sugarlevel2;
	}

	public void setSugarlevel2(int sugarlevel2) {
		this.sugarlevel2 = sugarlevel2;
	}
	
	
	
}
