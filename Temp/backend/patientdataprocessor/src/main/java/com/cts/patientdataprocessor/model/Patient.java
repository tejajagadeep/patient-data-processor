package com.cts.patientdataprocessor.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Patient {

	@Id
	private Long contactNumber;
	
	private String address;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private Date dateOfBirth;
	
	private String maritalStatus;
	
//	private String additioanlNote;
	
	private Long emergencyContactNumber;
	
	private String email;
	
	private String bloodGroup;
	
//	private String Bpcheck;
	
//	private String bloodSugarLvls;
	
	private String Disease;
	
	private Date dateVisited;
	
	private Date treatmentStartDate;
	
	private Date treatmentEndDate;
	
	private String prescription;
	
//	private String reports;
	
	private String height;
	
	private String weight;
	
//	@OneToMany(cascade = {
//			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
//	})
//	@JoinColumn(name = "contact_number")
//	private Set<Reports> reports;
//	
//	public void addProjects(Reports theReport) {
//
//		if (reports == null) {
////			storyAssignedToUsers = new ArrayList<>();
//			reports = new HashSet<>();
//		}
//
//		reports.add(theReport);
//
//	}
}
