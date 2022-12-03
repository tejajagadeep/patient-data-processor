package com.cts.patientdataprocessorresults.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
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

	public Results() {
		super();
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getWhiteBloodCells() {
		return whiteBloodCells;
	}

	public void setWhiteBloodCells(double whiteBloodCells) {
		this.whiteBloodCells = whiteBloodCells;
	}

	public double getRedBloodCells() {
		return redBloodCells;
	}

	public void setRedBloodCells(double redBloodCells) {
		this.redBloodCells = redBloodCells;
	}

	public double getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	public double getHemotocrit() {
		return hemotocrit;
	}

	public void setHemotocrit(double hemotocrit) {
		this.hemotocrit = hemotocrit;
	}

	public double getMeanCellVolume() {
		return meanCellVolume;
	}

	public void setMeanCellVolume(double meanCellVolume) {
		this.meanCellVolume = meanCellVolume;
	}

	public double getMeanCellHemoglobin() {
		return meanCellHemoglobin;
	}

	public void setMeanCellHemoglobin(double meanCellHemoglobin) {
		this.meanCellHemoglobin = meanCellHemoglobin;
	}

	public int getPlatelets() {
		return platelets;
	}

	public void setPlatelets(int platelets) {
		this.platelets = platelets;
	}

	public double getReticulocyte() {
		return reticulocyte;
	}

	public void setReticulocyte(double reticulocyte) {
		this.reticulocyte = reticulocyte;
	}
	
	
	
}

