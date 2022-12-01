package com.cts.authenticationmicroservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	@Column(name="systolic")
	private int systolic;
	
	@Column(name="diastolic")
	private int diastolic;
	
	@Column(name="sugar_level")
	private int sugarlevel;
	
}
