package com.cts.patientdataprocessorreport.model;

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
@Entity
@Table
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
	
	@Column(name="sugar_level_2")
	private int sugarlevel2;
	
}


