package com.cts.patientdataprocessorreport.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Long contactNumber;
	
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private Date date;
	
	@Column(name="systolic")
	private int systolic;
	
	@Column(name="diastolic")
	private int diastolic;
	
	@Column(name="sugar_level")
	private int sugarlevel;
	
	@Column(name="sugar_level_2")
	private int sugarlevel2;
	
}


