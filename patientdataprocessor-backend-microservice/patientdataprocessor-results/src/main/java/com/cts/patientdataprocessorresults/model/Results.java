package com.cts.patientdataprocessorresults.model;

import java.util.Date;

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
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Long contactNumber;
	
	private Date date;
	
	private double whiteBloodCells;
	
	private double redBloodCells;
	
	private double hemoglobin;
	
	private double hemotocrit;
	
	private double meanCellVolume;
	
	private double meanCellHemoglobin;
	
	private int  platelets;
	
	private double reticulocyte;
	
}

