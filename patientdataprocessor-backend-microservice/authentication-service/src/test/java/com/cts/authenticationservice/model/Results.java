package com.cts.authenticationservice.model;

import java.util.Date;
import java.util.Locale;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Long contactNumber;
	
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss ")
	private Locale date;
	
	private double whiteBloodCells;
	
	private double redBloodCells;
	
	private double hemoglobin;
	
	private double hemotocrit;
	
	private double meanCellVolume;
	
	private double meanCellHemoglobin;
	
	private int  platelets;
	
	private double reticulocyte;
	
}
