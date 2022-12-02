package com.cts.patientdataprocessorbackend.model;

import java.util.Date;

import javax.persistence.Entity;
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
	private Long contactNumber;
	
	private double whiteBloodCells;
	
	private double redBloodCells;
	
	private double hemoglobin;
	
	private double hemotocrit;
	
	private double meanCellVolume;
	
	private double meanCellHemoglobin;
	
	private int  platelets;
	
	private double reticulocyte;
	
}
