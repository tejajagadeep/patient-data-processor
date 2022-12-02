package com.cts.patientdataprocessorreport.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
	private String disease;
	
	private String diagnosis;
	
	private String previousDiagnosis;
	
	private Date dateVisited;
	
	private Date treatmentStartDate;
	
	private Date treatmentEndDate;
	
	private String prescription;
	
//	private String reports;
	
	private String height;
	
	private String weight;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_number")
	private Set<Report> reports;
	
	public void addReports(Report theReport) {

		if (reports == null) {
//			storyAssignedToUsers = new ArrayList<>();
			reports = new HashSet<>();
		}

		reports.add(theReport);

	}
}
